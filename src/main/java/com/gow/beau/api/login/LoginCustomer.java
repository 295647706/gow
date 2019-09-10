package com.gow.beau.api.login;

import com.auth0.jwt.JWT;
import com.gow.beau.model.req.customer.CustomerReq;
import com.gow.beau.model.rsp.customer.CustomerRsp;
import com.gow.beau.service.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName LoginCustomer
 * @Author lzn
 * @DATE 2019/9/9 11:25
 * 登陆用户信息
 */
@Controller
@RequestMapping("/login")
public class LoginCustomer {

    @Autowired
    public CustomerService customerService;

    /**
     * 获取登陆用户id
     * */
    public static Long getCustomerIdByToken(HttpServletRequest request){
        Long customerId = null;
        try{
            String token = request.getHeader("token");
            if (null != token && !token.equals("") && !token.equals("null")){
                customerId = JWT.decode(token).getClaim("id").asLong();
                return customerId;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return customerId;
    }

    /**
     * 获取登陆用户信息
     * */
    public CustomerRsp getCustomerByToken(HttpServletRequest request){
        CustomerRsp rsp = null;
        try{
            String token = request.getHeader("token");
            if (null != token && !token.equals("") && !token.equals("null")){
                Long customerId = JWT.decode(token).getClaim("id").asLong();
                if(null != customerId){
                    CustomerReq req = new CustomerReq();
                    req.setCustomerId(customerId);
                    return customerService.selectCustomerInfoByCustomerId(req);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return rsp;
    }
}
