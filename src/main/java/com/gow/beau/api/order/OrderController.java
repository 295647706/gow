package com.gow.beau.api.order;

import com.gow.beau.api.html.OrderPageController;
import com.gow.beau.api.payment.PayMent;
import com.gow.beau.model.req.order.*;
import com.gow.beau.model.rsp.order.OrderConfirmPageRsp;
import com.gow.beau.model.rsp.order.OrderListRsp;
import com.gow.beau.model.rsp.order.OrderStatusNumbersRsp;
import com.gow.beau.model.rsp.order.SaveOrderRsp;
import com.gow.beau.service.order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.util.List;

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
    public int paymentOrder(HttpServletResponse response,PaymentOrderReq req){
        int count = orderService.paymentOrder(req);
        if(count > 0){
            try {
                response.sendRedirect("/orderPage/order2-page");
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
}
