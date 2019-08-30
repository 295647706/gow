package com.gow.beau.boss.order;

import com.gow.beau.model.data.PageInfo;
import com.gow.beau.model.req.order.OrderExpressReq;
import com.gow.beau.model.req.order.OrderListReq;
import com.gow.beau.service.order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Administrator on 2019/4/21 0021.
 */
@Controller
@RequestMapping("/orderBoss")
public class OrderBossController {

    @Autowired
    private OrderService orderService;

    /**
     * 订单管理 - 订单列表页面
     * */
    @RequestMapping("/order-list-page")
    public ModelAndView orderListPage(){
        ModelAndView view = new ModelAndView("boss/order/orderList");
        return view;
    }

    /**
     * 订单管理 - 订单列表数据
     * */
    @RequestMapping("/orderListPage")
    @ResponseBody
    public PageInfo getOrderListPage(OrderListReq req){
        return orderService.getOrderListPage(req);
    }

    /**
     * 订单管理 - 物流发货
     * */
    @RequestMapping("/orderExpressSubmit")
    @ResponseBody
    public int orderExpressSubmit(OrderExpressReq req){
        return orderService.orderExpressSubmit(req);
    }


    /**
     * 订单管理 - 订单详情页面
     * */
    @RequestMapping("/order-detail-page")
    public ModelAndView orderDetailPage(Long orderId){
        ModelAndView view = new ModelAndView("boss/order/orderDetail");
        view.addObject("order",orderService.getOrderDetailInfo(orderId));
        return view;
    }

}
