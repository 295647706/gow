package com.gow.beau.util;

import com.gow.beau.model.data.GLpayApi;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @ClassName PayMentUtil
 * @Author lzn
 * @DATE 2019/9/2 16:11
 */
public class PayMentUtil {

    private static Logger logger = LogManager.getLogger();

    public static String UID = "4504";

    public static String NOTIFY_URL = "http://qpay/notifyPay";

    public static String RETURN_URL = "http://qpay/returnPay";

    //http://pay.aswe.com.cn
    //public static String BASE_URL = "http://pay.ebkf.net";
    public static String BASE_URL = "http://pay.aswe.com.cn";

    public static String TOKEN = "BZCchKH9tcuJJ9tBSJ0cXChH9petb98c";

    public static Map<String, Object> payOrder(Map<String, Object> remoteMap,String token) throws Exception{
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.putAll(remoteMap);
        paramMap.put("key", getKey(paramMap,token));
        return paramMap;
    }

    public static String getKey(Map<String, Object> remoteMap,String token) throws Exception{
        String key = "";
        if (null != remoteMap.get("goodsname")) {
            key += remoteMap.get("goodsname");
        }
        if (null != remoteMap.get("istype")) {
            key += remoteMap.get("istype");
        }
        if (null != remoteMap.get("notify_url")) {
            key += remoteMap.get("notify_url");
        }
        if (null != remoteMap.get("orderid")) {
            key += remoteMap.get("orderid");
        }
        if (null != remoteMap.get("orderuid")) {
            key += remoteMap.get("orderuid");
        }
        if (null != remoteMap.get("price")) {
            key += remoteMap.get("price");
        }
        if (null != remoteMap.get("return_url")) {
            key += remoteMap.get("return_url");
        }
        key += token;
        if (null != remoteMap.get("uid")) {
            key += remoteMap.get("uid");
        }
        return MD5Util.encryption(key);
    }

    public static boolean checkPayKey(GLpayApi payAPI) throws Exception{
        String key = "";
        if (!StringUtils.isBlank(payAPI.getOrderid())) {
            logger.info("支付回来的订单号：" + payAPI.getOrderid());
            key += payAPI.getOrderid();
        }
        if (!StringUtils.isBlank(payAPI.getOrderuid())) {
            logger.info("支付回来的支付记录的ID：" + payAPI.getOrderuid());
            key += payAPI.getOrderuid();
        }
        if (!StringUtils.isBlank(payAPI.getTrade_no())) {
            logger.info("支付回来的平台订单号：" + payAPI.getTrade_no());
            key += payAPI.getTrade_no();
        }
        if (!StringUtils.isBlank(payAPI.getPrice())) {
            logger.info("支付回来的价格：" + payAPI.getPrice());
            key += payAPI.getPrice();
        }
        if (!StringUtils.isBlank(payAPI.getRealprice())) {
            logger.info("支付回来的真实价格：" + payAPI.getRealprice());
            key += payAPI.getRealprice();
        }
        logger.info("支付回来的Key：" + payAPI.getKey());
        key += TOKEN;
        logger.info("我们自己拼接的Key：" + MD5Util.encryption(key));
        return payAPI.getKey().equals(MD5Util.encryption(key));
    }

    public static String getOrderIdByUUId() {
        int machineId = 1;// 最大支持1-9个集群机器部署
        int hashCodeV = UUID.randomUUID().toString().hashCode();
        if (hashCodeV < 0) {// 有可能是负数
            hashCodeV = -hashCodeV;
        }
        // 0 代表前面补充0;d 代表参数为正数型
        return machineId + String.format("%01d", hashCodeV);
    }
}
