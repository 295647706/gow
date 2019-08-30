package com.gow.beau.api.payment;

//import net.sf.json.JSONObject;

import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.HttpClientConnectionManager;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.BasicHttpClientConnectionManager;

import java.io.*;
import java.net.URL;
import java.security.SecureRandom;
import java.security.Security;
import java.security.cert.CertificateException;
import java.util.Map;
import javax.net.ssl.*;
import java.security.cert.X509Certificate;

/**
 * Created by admin on 2019/3/29.
 */
public class HttpsUtil {

    private final static HostnameVerifier DO_NOT_VERIFY = new HostnameVerifier() {
        @Override
        public boolean verify(String hostname, SSLSession session) {
            return true;
        }
    };

    private static void trustAllHosts() {
        // Create a trust manager that does not validate certificate chains
        TrustManager[] trustAllCerts = new TrustManager[]{new X509TrustManager() {
            @Override
            public X509Certificate[] getAcceptedIssuers() {
                return new X509Certificate[]{};
            }
            @Override
            public void checkClientTrusted(X509Certificate[] chain, String authType) {
            }

            @Override
            public void checkServerTrusted(X509Certificate[] chain, String authType) {
            }
        }};
        // Install the all-trusting trust manager
        try {
            SSLContext sc = SSLContext.getInstance("TLS");
            //Security.setProperty("jdk.tls.disabledAlgorithms","SSLv3, DH keySize < 768");
            //System.setProperty("https.protocols", "TLSv1.2");
            sc.init(null, trustAllCerts, new java.security.SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static  String https(String url, String sendString) throws Exception {
        // 构建请求参数
        String result = "";
        PrintWriter out = null;
        BufferedReader in = null;

        System.out.println("ERP连接:" + url);
        System.out.println("发送给ERP信息:" + sendString);

        try {
            trustAllHosts();
            URL url2 = new URL(url);

            HttpsURLConnection urlCon = (HttpsURLConnection) url2.openConnection();
            urlCon.setHostnameVerifier(DO_NOT_VERIFY);
            urlCon.setDoOutput(true);
            urlCon.setDoInput(true);
            urlCon.setRequestMethod("POST");
            urlCon.setRequestProperty("Content-type", "application/x-www-form-urlencoded");
            // 发送POST请求必须设置如下两行
            urlCon.setDoOutput(true);
            urlCon.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            OutputStream os = urlCon.getOutputStream();
            //编码格式
            String encoding = System.getProperty("sun.jnu.encoding");
            System.out.println("系统编码格式："+encoding);
            //参数是键值队  , 不以"?"开始
            os.write(sendString.getBytes());
            os.flush();
            // 发送请求参数
            //out.print(a);
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(
                    new InputStreamReader(urlCon.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                line = new String(line.getBytes());
                result += line;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {// 使用finally块来关闭输出流、输入流
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }


    public static String doPost(String requestUrl, String bodyStr, Map<String, String> header, String charset, String contentType) throws Exception {
        System.out.printf("--- https post 请求地址:%s 内容:%s", requestUrl, bodyStr);
        charset = null == charset ? "utf-8" : charset;

        // 创建SSLContext
        SSLContext sslContext = SSLContext.getInstance("SSL");
        TrustManager[] trustManagers = {new X509TrustManager() {
            /*
             * 实例化一个信任连接管理器
             * 空实现是所有的连接都能访问
             */
            @Override
            public void checkClientTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {

            }

            @Override
            public void checkServerTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {

            }

            @Override
            public X509Certificate[] getAcceptedIssuers() {
                return new X509Certificate[0];
            }
        }};
        // 初始化
        sslContext.init(null, trustManagers, new SecureRandom());
        SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();

        URL url = new URL(requestUrl);
        HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url.openConnection();
        httpsURLConnection.setSSLSocketFactory(sslSocketFactory);

        // 以下参照http请求
        httpsURLConnection.setDoOutput(true);
        httpsURLConnection.setDoInput(true);
        httpsURLConnection.setUseCaches(false);
        httpsURLConnection.setRequestMethod("POST");
        httpsURLConnection.setRequestProperty("Accept-Charset", charset);
        if (null != bodyStr) {
            httpsURLConnection.setRequestProperty("Content-Length", String.valueOf(bodyStr.length()));
        }
        if (contentType == null) {
            httpsURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        } else {
            httpsURLConnection.setRequestProperty("Content-Type", contentType);
        }
        if (!header.isEmpty()) {
            for (Map.Entry<String, String> entry : header.entrySet()) {
                httpsURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
            }
        }
        httpsURLConnection.connect();

        // 读写内容
        OutputStream outputStream = null;
        InputStream inputStream = null;
        InputStreamReader streamReader = null;
        BufferedReader bufferedReader = null;
        StringBuffer stringBuffer;
        try {
            if (null != bodyStr) {
                outputStream = httpsURLConnection.getOutputStream();
                outputStream.write(bodyStr.getBytes(charset));
                outputStream.close();
            }

            if (httpsURLConnection.getResponseCode() >= 300) {
                throw new Exception("https post failed, response code " + httpsURLConnection.getResponseCode());
            }

            inputStream = httpsURLConnection.getInputStream();
            streamReader = new InputStreamReader(inputStream, charset);
            bufferedReader = new BufferedReader(streamReader);
            stringBuffer = new StringBuffer();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuffer.append(line);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if (outputStream != null) {
                outputStream.close();
            }
            if (inputStream != null) {
                inputStream.close();
            }
            if (streamReader != null) {
                streamReader.close();
            }
            if (bufferedReader != null) {
                bufferedReader.close();
            }
        }
        System.out.printf("--- https post 返回内容:%s", stringBuffer.toString());
        return stringBuffer.toString();
    }

}
