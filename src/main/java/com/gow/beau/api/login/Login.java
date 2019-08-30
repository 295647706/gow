package com.gow.beau.api.login;

import com.auth0.jwt.JWT;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.gow.beau.api.customer.CustomerController;
import com.gow.beau.model.data.User;
import com.gow.beau.model.req.login.LoginReq;
import com.gow.beau.model.rsp.login.LoginRsp;
import com.gow.beau.model.rsp.token.TokenRsp;
import com.gow.beau.storage.auto.model.Customer;
import com.gow.beau.util.JsonObject;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by lzn on 2019/2/27.
 */
@Controller
@RequestMapping("/login")
public class Login {

    @Autowired
    private CustomerController customerController;

    /**
     * lzn 2019/2/28 11:20
     * 进入登陆页面
     */
    @RequestMapping("/login-page")
    public ModelAndView loginPage(){
        ModelAndView view = new ModelAndView("login/new/login2");
        return view;
    }

    /**
     * lzn 2019/2/28 11:27
     * 登陆
     */
    @RequestMapping("/login")
    @ResponseBody
    public TokenRsp login(LoginReq req){
        LoginRsp loginRsp = customerController.selectCustomerNameAndPaddByName(req.getName());
        TokenRsp tokenRsp = new TokenRsp();
        if(loginRsp == null){
            tokenRsp.setMessage("登陆失败，用户不存在");
            return tokenRsp;
        }

        if(loginRsp.getIsUse().equals("1")){
            tokenRsp.setMessage("用户已被冻结,请联系管理员解冻");
            return tokenRsp;
        }

        if(!loginRsp.getCustomerPassword().equals(req.getPass())){
            tokenRsp.setMessage("密码错误");
            return tokenRsp;
        }

        User user = new User();
        user.setId(loginRsp.getCustomerId());
        user.setUserName(loginRsp.getCustomerUsername());
        user.setPassWord(loginRsp.getCustomerPassword());

        String token = JwtLogin.createJWT(null,user);

        tokenRsp.setToken(token);
        return tokenRsp;
    }

    /**
     * lzn 2019/3/15 21:26
     * 验证token 是否有效
     * 并返回 customerId,customerName
     */
    @RequestMapping("/isTokenToUser")
    @ResponseBody
    public User isTokenToUser(HttpServletRequest request){
        String token = request.getHeader("token");
        Long customerId = JWT.decode(token).getClaim("id").asLong();
        if(null == customerId){
            throw new RuntimeException("登陆失效");
        }

        Customer customer = customerController.getCustomer(customerId);
        if(null == customer){
            throw new RuntimeException("用户不存在，请重新登陆");
        }

        User user = new User();
        user.setId(customer.getId());
        user.setUserName(customer.getCustomerUsername());
        user.setPassWord(customer.getCustomerPassword());
        Boolean isVerify = JwtLogin.isVerify(token,user);
        if(!isVerify){
            //throw new RuntimeException("非法的访问:用户名或密码错误");
            //到这里说明用户已经登陆了，签发新的token

            String newToken = JwtLogin.createJWT(null,user);
            user.setToken(newToken);
        }
        return user;
    }

}
