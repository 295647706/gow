package com.gow.beau.api.payment;

//import net.sf.json.JSONObject;

import java.io.*;
import java.net.URL;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import java.security.cert.X509Certificate;
import javax.net.ssl.X509TrustManager;

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

}
