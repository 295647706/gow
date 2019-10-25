package com.gow.beau.api.payment;

import com.gow.beau.storage.auto.model.Payment;
import com.gow.beau.util.JsonObject;
import com.gow.beau.util.MD5;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.entity.StringEntity;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.CoreConnectionPNames;

import org.apache.http.conn.ssl.SSLSocketFactory;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by lzn on 2019/3/27.
 * 支付
 */
public class PayMent {

    public static String httpsPost(String orderCode, String orderPayType, String order_customer_id, BigDecimal price , String goodsNames, Payment payment){
        if(null != payment.getIsDefaultPrice() && payment.getIsDefaultPrice().equals("1")) {
            //这里金额暂时默认,测试使用
            price = payment.getDefaultPrice();
        }
        double priceValue = price.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();

        //替换商品中有“+”的符号
        goodsNames = goodsNames.replace("+","_");

        //设置订单过期时间
        int expire = 24*60*60*1000;
        if(null != payment.getExpire() && payment.getExpire() > 0){
            expire = payment.getExpire();
        }

        //域名
        String path = payment.getPath(); //"http://gow.hdongx.com";

        String apiUrl = payment.getApiUrl(); //"https://bufpay.com/api/pay/95134";
        String appSecret = payment.getAppEcret(); //"967e0dc6b34e46c082af6997253fde6c";
        String orderId = orderCode;       // 自己创建的本地订单号
        String orderUid = order_customer_id;  //订单对应的用户id

        String payType = "wechat";    // 付款方式,默认微信
        if(null != orderPayType) {
            if (orderPayType.equals("1")) {
                payType = "wechat";
            } else if (orderPayType.equals("2")) {
                payType = "alipay";//支付宝
            }
        }

        //path + "/order/paymentOrder?orderCode="+orderId/*+"&payType="+orderPayType*/;
        // 回调通知地址 http://gow.hdongx.com/order/paymentOrder?orderCode=1
        String notifyUrl = path + payment.getNotifyUrl() + orderId;
        //path + "/orderPage/order2-page";   // 支付成功页面跳转地址
        String returnUrl = path + payment.getReturnUrl();
        String paramData=goodsNames+payType+priceValue+orderId+orderUid+notifyUrl+returnUrl+appSecret;
        String sign = MD5.md5(paramData);
        String sendString="name="+goodsNames+"&pay_type="+payType+"&price="+priceValue+"&order_id="+orderId
                +"&order_uid="+orderUid+"&notify_url="+notifyUrl+"&return_url="+returnUrl
                +"&sign="+sign+"&expire="+expire;
        String responseData=null;
        try {
            responseData=HttpsUtil.https(apiUrl,sendString);
            //responseData=HttpsUtil.doPost(apiUrl,sendString,null,null,null);
        }catch (Exception e){
        }
        System.err.println(responseData);
        return responseData;
    }

    /**
     * DefaultHttpClient格式化，使之不需要SSL证书也可以打通SSL 如果不格式化会报错：
     * javax.net.ssl.SSLPeerUnverifiedException: peer not authenticate
     * @param base
     * @return
     */
    public static DefaultHttpClient wrapClient(DefaultHttpClient base) {
        SSLContext sslContext;
        try {
            sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, new TrustManager[] { new X509TrustManager() {
                public X509Certificate[] getAcceptedIssuers() {
                    return null;
                }


                public void checkClientTrusted(X509Certificate[] certs,
                                               String authType) {
                }


                public void checkServerTrusted(X509Certificate[] certs,
                                               String authType) {
                }
            } }, new SecureRandom());
            SSLSocketFactory ssf = new SSLSocketFactory(sslContext,
                    SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
            SchemeRegistry registry = new SchemeRegistry();
            registry.register(new Scheme("https", 443, ssf));
            ThreadSafeClientConnManager mgr = new ThreadSafeClientConnManager(
                    registry);
            return new DefaultHttpClient(mgr, base.getParams());
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public static boolean httpPostWithJson(String url, String pay_type, String order_id, String order_customer_id, BigDecimal price ,String... goodsNames){
        boolean isSuccess = false;

        HttpPost post = null;
        try{
            DefaultHttpClient httpClient = new DefaultHttpClient();
            // 格式化打通SSL
            httpClient = wrapClient(httpClient);
            //设置超时时间
            httpClient.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT,2000);
            httpClient.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT,2000);

            //请求
            post = new HttpPost(url);

            //构造消息头
            post.setHeader("Content-type","application/x-www-form-urlencoded");
            //post.setHeader("Connection","Close");

            //构建消息实体
            Map<String,Object> map = new HashMap<>();
            String goodss = "";
            if(null != goodsNames && goodsNames.length > 0){
                goodss = goodss.equals("")?goodss:goodss+","+goodsNames;
            }
            map.put("name",goodss);//必填, 订单销售商品名称
            map.put("pay_type",pay_type==null?pay_type:"alipay");//必填, 支付方式（可选alipay/wechat）
            map.put("price",price);//必填, 订单价格
            map.put("order_id",order_id);//必填, 订单号
            map.put("order_uid",order_customer_id);//必填, 订单购买用户（可以为空字符串，但是建议设置为购买用户编号，便于后续对账）
            map.put("notify_url","/orderPage/paymentOrder");//必填, 支付成功后回调地址
            map.put("return_url","/orderPage/order-page");//必填, 支付成功后前台跳转地址（可以为空字符串）
            map.put("feedback_url","");//选填, 用户支付后未到账（可能超时付款），支付页面显示的反馈按钮链接（可以为空字符串）
            /*
            * sign 必填, 将参数按
            name + pay_type + price + order_id + order_uid + notify_url + return_url + feedback_url + app secret
            顺序拼接后MD5（纯 value 拼接，不要包含 + 号）
            * */
            StringBuffer sbufferSign = new StringBuffer();
            sbufferSign.append(map.get("name"))
                    .append(map.get("pay_type"))
                    .append(map.get("price"))
                    .append(map.get("order_id"))
                    .append(map.get("order_uid"))
                    .append(map.get("notify_url"))
                    .append(map.get("return_url"))
                    .append(map.get("feedback_url"));
            map.put("sign",sbufferSign);

            String json = JsonObject.mapToJson(map);
            StringEntity entity = new StringEntity(json, Charset.forName("UTF-8"));
            entity.setContentEncoding("UTF-8");

            //发送json格式的数据请求
            entity.setContentType("application/json");
            post.setEntity(entity);

            HttpResponse response = httpClient.execute(post);

            //检验返回码
            int statusCode = response.getStatusLine().getStatusCode();
            if(statusCode != HttpStatus.SC_OK){
                System.err.print("请求出错："+statusCode);
                return isSuccess;
            }

            HttpEntity getEntity = response.getEntity();
            System.out.print(getEntity);

            isSuccess = true;
            return isSuccess;

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(null != post){
                try{
                    post.releaseConnection();
                    Thread.sleep(500);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
        return isSuccess;
    }

    public static void main(String[] args) {
        Payment payment = new Payment();
        payment.setPath("http://gow.hdongx.com");
        payment.setApiUrl("https://bufpay.com/api/pay/95134");
        payment.setReturnUrl("/orderPage/order2-page");
        payment.setAppEcret("967e0dc6b34e46c082af6997253fde6c");
        System.err.println(httpsPost("201908261310111234","wechat","1001",new BigDecimal(0.01),"商品1",payment));
    }
}
