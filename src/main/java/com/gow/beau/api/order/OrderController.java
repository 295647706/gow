package com.gow.beau.api.order;

import com.gow.beau.api.html.OrderPageController;
import com.gow.beau.api.payment.PayMent;
import com.gow.beau.model.data.PayMentZfm;
import com.gow.beau.model.req.order.*;
import com.gow.beau.model.rsp.order.*;
import com.gow.beau.service.order.OrderService;
import com.gow.beau.service.ordergoods.OrderGoodsService;
import com.gow.beau.service.payment.PaymentService;
import com.gow.beau.storage.auto.model.Order;
import com.gow.beau.storage.auto.model.Payment;
import com.gow.beau.util.PayMentUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lzn on 2019/3/5.
 */
@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderPageController orderPageController;

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderGoodsService orderGoodsService;

    @Autowired
    private PaymentService paymentService;

    /**
     * lzn 2019/3/5 18:28
     * 提交订单，保存订单
     */
    @RequestMapping("/saveOrder")
    @ResponseBody
    public SaveOrderRsp saveOrder(HttpServletRequest request,SaveOrderReq req)
    {
        //ModelAndView view = new ModelAndView("order/order-pay");
        SaveOrderRsp saveOrderRsp = orderService.saveOrder(request,req);
        //view.addObject("saveOrderInfo",saveOrderRsp);
        return saveOrderRsp;
    }

    /**
     * lzn 2019/3/6 9:00
     * 确认下单信息
     */
    @RequestMapping("/orderConfirmInfo")
    @ResponseBody
    public OrderConfirmPageRsp orderConfirmInfo(OrderConfirmPageReq req) {
        return orderService.orderConfirmInfo(req);
    }

    /**
     * lzn 2019/3/12 16:44
     * 订单列表
     */
    @RequestMapping("/orderList")
    @ResponseBody
    public List<OrderListRsp> orderList(HttpServletRequest request,OrderListReq req){
        return orderService.orderList(request,req);
    }

    /**
     * lzn 2019/3/14 15:44
     * 查询订单各个状态的数量
     */
    @RequestMapping("/orderStatusNumbers")
    @ResponseBody
    public OrderStatusNumbersRsp orderStatusNumbers(HttpServletRequest request,OrderStatusNumbersReq req){
        return orderService.orderStatusNumbers(request,req);
    }

    /**
     * lzn 2019/3/15 11:26
     * 确认收货
     */
    @RequestMapping("/confirmReceipt")
    @ResponseBody
    public int confirmReceipt(ConfirmReceiptReq req){
        return orderService.confirmReceipt(req);
    }

    /**
     * lzn 2019/3/19 15:28
     * 确认支付，去支付
     */
    @RequestMapping("/paymentOrder")
    @ResponseBody
    public int paymentOrder(PaymentOrderReq req){
        int count = orderService.paymentOrder(req);
        if(count > 0){
            try {
                //response.sendRedirect("/orderPage/order2-page");
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return count;
    }

    @RequestMapping("/pay")
    @ResponseBody
    public String pay(PaymentOrderReq req){
        return orderService.pay(req);
    }

    /**
     * lzn 2019/3/31 15:31
     * 根据订单编号查询订单金额
     */
    public BigDecimal selectOrderPriceByorderCode(String orderCode) {
        return orderService.selectOrderPriceByorderCode(orderCode);
    }

    /**
     * 根据订单编号查询订单详情
     * */
    public Order getOrder(String orderCode){
        return orderService.getOrder(orderCode);
    }

    /**
     * 确认支付请求时处理数据
     * */
    @RequestMapping("/doPayMentZfm")
    @ResponseBody
    public PayMentZfm doPayMentZfm(PayMentZfmRsp rsp) throws Exception{
        //订单信息
        Order order = orderService.getOrder(rsp.getOrderCode());
        //订单商品名称
        String goodsNames = orderGoodsService.selectGoodsNamesByorderId(order.getId());
        //支付配置信息
        Payment payment = paymentService.selectFirstPaymentInfo("docpay");
        return getPayMentZfm(order,rsp.getPayType(),goodsNames,payment);
    }

    private PayMentZfm getPayMentZfm(Order order, String payType, String goodsNames, Payment payment) throws Exception{
        Map<String, Object> remoteMap = new HashMap<>();
        //订单金额
        //是否开启默认支付金额（0：不开启，1：开启）
        if(null == payment.getIsDefaultPrice() || payment.getIsDefaultPrice().equals("0")) {
            remoteMap.put("price", order.getOrderPrice());
        }else if(payment.getIsDefaultPrice().equals("1")){
            remoteMap.put("price", payment.getDefaultPrice());
        }
        //支付类型（1：支付宝；2：微信支付）
        remoteMap.put("istype", payType);
        //商户自定义订单号
        remoteMap.put("orderid", order.getOrderCode());
        //商户自定义客户号
        remoteMap.put("orderuid", order.getCustomerId());
        //订单商品
        remoteMap.put("goodsname", goodsNames);
        //商户id
        remoteMap.put("uid", payment.getUid());
        //通知回调网址
        remoteMap.put("notify_url", payment.getPath()+payment.getNotifyUrl());
        //跳转网址
        remoteMap.put("return_url", payment.getPath()+payment.getReturnUrl());
        //创建key值
        Map<String, Object> rmap = PayMentUtil.payOrder(remoteMap,payment.getAppEcret());

        PayMentZfm zfm = new PayMentZfm();
        zfm.setPrice(remoteMap.get("price").toString().trim());
        zfm.setIstype(remoteMap.get("istype").toString().trim());
        zfm.setOrderid(remoteMap.get("orderid").toString().trim());
        zfm.setOrderuid(remoteMap.get("orderuid").toString().trim());
        zfm.setGoodsname(remoteMap.get("goodsname").toString().trim());
        zfm.setUid(rmap.get("uid").toString().trim());
        zfm.setNotifyUrl(rmap.get("notify_url").toString().trim());
        zfm.setReturnUrl(rmap.get("return_url").toString().trim());
        zfm.setKey(rmap.get("key").toString().trim());
        zfm.setBaseUrl(payment.getApiUrl().trim());

        return zfm;
    }
}
