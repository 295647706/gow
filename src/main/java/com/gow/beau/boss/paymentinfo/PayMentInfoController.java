package com.gow.beau.boss.paymentinfo;

import com.gow.beau.model.data.PageInfo;
import com.gow.beau.model.req.payment.PayMentAddEditReq;
import com.gow.beau.model.req.payment.PayMentListReq;
import com.gow.beau.service.payment.PaymentService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @ClassName PayMentInfoController
 * @Author lzn
 * @DATE 2019/9/3 10:31
 * 支付配置管理
 */
@Api(tags = "后台管理 - 支付配置管理")
@Controller
@RequestMapping("/payMentInfoBoss")
public class PayMentInfoController {

    @Autowired
    private PaymentService paymentService;

    /**
     * 支付配置 - 列表页面
     * */
    @RequestMapping("/pay-list-page")
    public ModelAndView payListPage(){
        ModelAndView view = new ModelAndView("boss/basicinfo/payment/payList");
        return view;
    }

    /**
     * 支付通道配置信息 - 列表数据
     * */
    @RequestMapping("/payListPage")
    @ResponseBody
    public PageInfo getPayListPage(PayMentListReq req){
        return paymentService.getPayListPage(req);
    }

    /**
     * 支付配置 - 新增页面
     * */
    @RequestMapping("/pay-add-page")
    public ModelAndView payAddPage(){
        ModelAndView view = new ModelAndView("boss/basicinfo/payment/payAdd");
        return view;
    }

    /**
     * 新增支付信息
     * */
    @RequestMapping("/addPayInfo")
    @ResponseBody
    public int addPayInfo(PayMentAddEditReq req){
        return paymentService.addPayInfo(req);
    }

    /**
     * 支付配置 - 编辑页面
     * */
    @RequestMapping("/pay-edit-page")
    public ModelAndView payEditPage(Long payId){
        ModelAndView view = new ModelAndView("boss/basicinfo/payment/payEdit");
        view.addObject("pay",paymentService.getPaymentById(payId));
        return view;
    }

    /**
     * 编辑支付信息
     * */
    @RequestMapping("/editPayInfo")
    @ResponseBody
    public int editPayInfo(PayMentAddEditReq req){
        return paymentService.editPayInfo(req);
    }


    /**
     * 删除支付信息
     * */
    @RequestMapping("/deletePayInfo")
    @ResponseBody
    public int deletePayInfo(Long payId){
        return paymentService.deletePayInfo(payId);
    }
}
