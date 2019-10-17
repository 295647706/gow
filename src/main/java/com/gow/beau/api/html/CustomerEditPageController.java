package com.gow.beau.api.html;

import com.gow.beau.api.customer.CustomerController;
import com.gow.beau.model.req.customer.CustomerReq;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Date: 2019/2/18 13:51<br/>
 *
 * @author lzn
 */
@Api(tags = "页面 - 会员")
@Controller
@RequestMapping("/customerEditPage")
public class CustomerEditPageController {

    @Autowired
    private CustomerController customerController;

    @RequestMapping("/customer-edit-page")
    public ModelAndView customerEditPage(CustomerReq req){
        ModelAndView view = new ModelAndView("customer/customer-edit");
        view.addObject("customerInfo",customerController.selectCustomerInfoByCustomerId(req));
        return view;
    }
}
