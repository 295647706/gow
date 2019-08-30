package com.gow.beau.boss.customer;

import com.gow.beau.model.data.PageInfo;
import com.gow.beau.model.req.customer.CustomerIsUerReq;
import com.gow.beau.model.req.customer.CustomerListPageReq;
import com.gow.beau.model.rsp.customer.CustomerListPageRsp;
import com.gow.beau.service.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @ClassName CustomerBossController
 * @Author lzn
 * @DATE 2019/8/29 17:38
 */
@Controller
@RequestMapping("/customerBoss")
public class CustomerBossController {

    @Autowired
    private CustomerService customerService;

    /**
     * 会员管理 - 会员列表页面
     * */
    @RequestMapping("/customer-list-page")
    public ModelAndView orderListPage(){
        ModelAndView view = new ModelAndView("boss/customer/customerList");
        return view;
    }

    /**
     * 会员管理 - 会员列表数据
     * */
    @RequestMapping("/customerListPage")
    @ResponseBody
    public PageInfo getCustomerListPage(CustomerListPageReq req){
        return customerService.getCustomerListPage(req);
    }

    /**
     * 删除会员
     * */
    @RequestMapping("/deleteCustomerManage")
    @ResponseBody
    public int deleteCustomerManage(Long customerId){
        return customerService.deleteCustomerManage(customerId);
    }

    /**
     * 会员详情 页面
     * */
    @RequestMapping("/detailCustomerManagePage")
    public ModelAndView detailCustomerManage(Long customerId){
        ModelAndView view = new ModelAndView("boss/customer/customerDetail");
        view.addObject("customer",customerService.detailCustomerManage(customerId));
        return view;
    }

    /**
     * 修改冻结状态
     * */
    @RequestMapping("/updateCustomerIsUse")
    @ResponseBody
    public int updateCustomerIsUse(CustomerIsUerReq req){
        return customerService.updateCustomerIsUse(req);
    }

}
