package com.gow.beau.api.customer;

import com.gow.beau.model.req.customer.CustomerEditPassReq;
import com.gow.beau.model.req.customer.CustomerReq;
import com.gow.beau.model.req.customer.EditCustomerInfoReq;
import com.gow.beau.model.req.regist.RegistUsernameReq;
import com.gow.beau.model.rsp.customer.CustomerInfoRsp;
import com.gow.beau.model.rsp.customer.CustomerRsp;
import com.gow.beau.model.rsp.login.LoginRsp;
import com.gow.beau.service.customer.CustomerService;
import com.gow.beau.storage.auto.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Date: 2019/2/18 14:14<br/>
 *
 * @author lzn
 */
@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping("/selectCustomerInfoByCustomerId")
    public CustomerRsp selectCustomerInfoByCustomerId(CustomerReq req){
        return customerService.selectCustomerInfoByCustomerId(req);
    }

    @RequestMapping("/editCustomerInfo")
    public int editCustomerInfo(EditCustomerInfoReq req){
        return customerService.editCustomerInfo(req);
    }


    public LoginRsp selectCustomerNameAndPaddByName(String name) {
        return customerService.selectCustomerNameAndPaddByName(name);
    }

    public Customer getCustomer(Long customerId){return customerService.selectCustomerInfoByCustomerId(customerId);}

    /**
     * lzn 2019/3/18 15:09
     * 查询会员的信息
     */
    @RequestMapping("/selectCustomerInfo")
    @ResponseBody
    public CustomerInfoRsp selectCustomerInfo(HttpServletRequest request){
        return customerService.selectCustomerInfo(request);
    }

    /**
     * lzn 2019/3/19 14:48
     * 创建用户
     */
    @RequestMapping("/addCustomer")
    @ResponseBody
    public int addCustomer(Customer customer) {
        return customerService.addCustomer(customer);
    }

    /**
     * lzn 2019/3/19 15:07
     * 根据用户名检查用户是否存在
     */
    @RequestMapping("/isExistCustomerUsername")
    @ResponseBody
    public boolean isExistCustomerUsername(RegistUsernameReq req){
        return customerService.isExistCustomerUsername(req);
    }


    @RequestMapping("/editPass")
    @ResponseBody
    public String editPass(HttpServletRequest request, CustomerEditPassReq req){
        return customerService.editPass(request,req);
    }
}
