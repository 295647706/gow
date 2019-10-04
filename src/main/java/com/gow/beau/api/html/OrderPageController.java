package com.gow.beau.api.html;

import com.gow.beau.api.order.OrderController;
import com.gow.beau.model.req.order.OrderConfirmPageReq;
import com.gow.beau.model.rsp.order.SaveOrderRsp;
import com.gow.beau.service.ordergoods.OrderGoodsService;
import com.gow.beau.service.payment.PayTypeService;
import com.gow.beau.storage.auto.model.Paytype;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
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

    @Autowired
    private PayTypeService payTypeService;

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
    public ModelAndView orderPayPage(SaveOrderRsp rsp) throws Exception{
        BigDecimal price = orderController.selectOrderPriceByorderCode(rsp.getOrderCode());
        rsp.setOrderPrice(price);
        ModelAndView view = new ModelAndView("order/order-pay");
        view.addObject("saveOrderInfo",rsp);
        //支付类型
        List<Paytype> paytypeList = payTypeService.getPaytypeAll();
        //找出默认类型
        String type = "";
        for(Paytype paytype : paytypeList){
            if(paytype.getIsDefault().equals("1")){
                if(paytype.getPayType().equals("alipay")){
                    type = "1";
                }else if(paytype.getPayType().equals("wechat")){
                    type = "2";
                }
            }
            if(paytype.getPayType().equals("alipay")){
                paytype.setPayType("1");
            }else if(paytype.getPayType().equals("wechat")){
                paytype.setPayType("2");
            }
        }
        view.addObject("paytypeList", paytypeList);
        view.addObject("type",type);
        return view;
    }


    /**
     * 支付猫支付成功，跳转地址
     * */
    @GetMapping("/to_return_page")
    public ModelAndView returnPayOrderPage(@PathVariable("orderid")String orderid){
        System.err.print("支付猫支付成功，跳转地址:orderid = " + orderid);
        ModelAndView view = this.orderPage2("");
        return view;
    }

}
