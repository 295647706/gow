package com.gow.beau.api.html;

import com.gow.beau.api.order.OrderController;
import com.gow.beau.model.req.order.OrderConfirmPageReq;
import com.gow.beau.model.rsp.order.SaveOrderRsp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * Date: 2019/2/18 11:25<br/>
 *
 * @author lzn
 */
@Controller
@RequestMapping("/orderPage")
public class OrderPageController {

    @Autowired
    private OrderController orderController;

    @RequestMapping("/order-page")
    public ModelAndView orderPage(){
        ModelAndView view = new ModelAndView("order/order");
        return view;
    }

    @RequestMapping("/order2-page")
    public ModelAndView orderPage2(String orderStatus){
        ModelAndView view = new ModelAndView("order/new/orders-list");
        view.addObject("orderStatus",orderStatus);
        return view;
    }

    @RequestMapping("/order-confirm-page")
    public ModelAndView orderConfirmPage(OrderConfirmPageReq req){
        ModelAndView view = new ModelAndView("order/order-confirm");
        view.addObject("orderConfirmInfo",orderController.orderConfirmInfo(req));
        UUID uuid = UUID.randomUUID();
        view.addObject("uuid",uuid);
        return view;
    }

    /**
     * lzn 2019/3/18 14:41
     * 订单确认支付页面
     */
    @RequestMapping("/order-pay-page")
    public ModelAndView orderPayPage(SaveOrderRsp rsp){
        BigDecimal price = orderController.selectOrderPriceByorderCode(rsp.getOrderCode());
        rsp.setOrderPrice(price);
        ModelAndView view = new ModelAndView("order/order-pay");
        view.addObject("saveOrderInfo",rsp);
        return view;
    }
}
