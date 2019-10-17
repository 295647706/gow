package com.gow.beau.boss.paymentinfo;

import com.gow.beau.model.data.PageInfo;
import com.gow.beau.model.req.payment.PayTypeListReq;
import com.gow.beau.service.payment.PayTypeService;
import com.gow.beau.storage.auto.model.Paytype;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @ClassName PayTypeController
 * @Author lzn
 * @DATE 2019/9/9 14:02
 * 支付类型
 */
@Api(tags = "后台管理 - 支付类型")
@Controller
@RequestMapping("/payTypeBoss")
public class PayTypeController {

    @Autowired
    private PayTypeService payTypeService;

    /**
     * 支付类型设置 - 页面
     * */
    @RequestMapping("/paytype-list-page")
    public ModelAndView paytypeListPage(){
        ModelAndView view = new ModelAndView("boss/basicinfo/payment/paytypeList");
        return view;
    }

    /**
     * 支付类型 - 列表数据
     * */
    @RequestMapping("/payTypeListPage")
    @ResponseBody
    public PageInfo getPayTypeListPage(PayTypeListReq req){
        return payTypeService.getPayTypeListPage(req);
    }

    /**
     * 一键生成支付设置
     * */
    @RequestMapping("/setPayType")
    @ResponseBody
    public int setPayType(){
        return payTypeService.setPayType();
    }

    /**
     * 删除
     * */
    @RequestMapping("/payTypeDelete")
    @ResponseBody
    public int payTypeDelete(Long payTypeId){
        return payTypeService.payTypeDelete(payTypeId);
    }

    /**
     * 设置默认
     * */
    @RequestMapping("/isDefault")
    @ResponseBody
    public int isDefault(Long payTypeId){
        return payTypeService.isDefault(payTypeId);
    }

    /**
     * 设置启动、禁用
     * */
    @RequestMapping("/isUse")
    @ResponseBody
    public int isUse(Long payTypeId){
        return payTypeService.isUse(payTypeId);
    }


    /**
     * 支付类型修改 - 页面
     * */
    @RequestMapping("/paytype-update-page")
    public ModelAndView paytypeUpdatePage(Long payTypeId){
        ModelAndView view = new ModelAndView("boss/basicinfo/payment/paytypeUpdate");
        view.addObject("paytype",payTypeService.getPaytypeByid(payTypeId));
        return view;
    }

    /**
     * 修改内容
     * */
    @RequestMapping("/updateContent")
    @ResponseBody
    public int updateContent(Paytype paytype){
        return payTypeService.updateContent(paytype);
    }

}
