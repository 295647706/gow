package com.gow.beau.api.payment;

import com.gow.beau.model.data.GLpayApi;
import com.gow.beau.util.PayMentUtil;
import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName PayMentController
 * @Author lzn
 * @DATE 2019/9/2 16:10
 */
@Api(tags = "数据 - 支付")
@Controller
@RequestMapping("/payment")
public class PayMentController {

    @RequestMapping("/pay")
    @ResponseBody
    public Map<String, Object> pay(HttpServletRequest request, float price, int istype) throws Exception{
        Map<String, Object> resultMap = new HashMap<String, Object>();
        Map<String, Object> remoteMap = new HashMap<String, Object>();
        remoteMap.put("price", price);
        remoteMap.put("istype", istype);
        remoteMap.put("orderid", PayMentUtil.getOrderIdByUUId());
        remoteMap.put("orderuid", "您自己想要传输的ID");
        remoteMap.put("goodsname", "您自己的商品名称");
        resultMap.put("data", PayMentUtil.payOrder(remoteMap,null));
        return resultMap;
    }

    @RequestMapping("/notifyPay")
    public void notifyPay(HttpServletRequest request, HttpServletResponse response, GLpayApi payAPI) throws Exception{
        // 保证密钥一致性
        if (PayMentUtil.checkPayKey(payAPI)) {
            // TODO 做自己想做的
        } else {
            // TODO 该怎么做就怎么做
        }
    }

    @RequestMapping("/returnPay")
    public ModelAndView returnPay(HttpServletRequest request, HttpServletResponse response, String orderid) {
        boolean isTrue = false;
        ModelAndView view = null;
        // 根据订单号查找相应的记录:根据结果跳转到不同的页面
        if (isTrue) {
            view = new ModelAndView("/正确的跳转地址");
        } else {
            view = new ModelAndView("/没有支付成功的地址");
        }
        return view;
    }
}
