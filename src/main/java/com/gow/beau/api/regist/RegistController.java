package com.gow.beau.api.regist;

import com.gow.beau.api.customer.CustomerController;
import com.gow.beau.api.login.Login;
import com.gow.beau.model.data.User;
import com.gow.beau.model.req.login.LoginReq;
import com.gow.beau.model.req.regist.RegistUsernameReq;
import com.gow.beau.model.rsp.token.TokenRsp;
import com.gow.beau.storage.auto.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * Created by lzn on 2019/3/19.
 */
@Controller
@RequestMapping("/regist")
public class RegistController {

    @Autowired
    private CustomerController customerController;

    @Autowired
    private Login login;

    /**
     * lzn 2019/3/19 14:43
     * 注册新用户
     */
    @RequestMapping("/registUsername")
    @ResponseBody
    public TokenRsp registUsername(RegistUsernameReq req){
        Date date = new Date();
        Customer customer = new Customer();
        customer.setCustomerUsername(req.getUsername());
        customer.setMobile(req.getUsername());
        customer.setCustomerPassword(req.getPassword());
        customer.setLoginIp(req.getIp());
        customer.setLoginTime(date);
        customer.setCreateTime(date);
        int count = customerController.addCustomer(customer);
        if(count > 0){
            LoginReq loginReq = new LoginReq();
            loginReq.setName(req.getUsername());
            loginReq.setPass(req.getPassword());
            return login.login(loginReq);
        }
        return null;
    }
}
