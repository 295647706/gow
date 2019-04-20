package com.gow.beau.autowired;

import com.auth0.jwt.JWT;
import com.gow.beau.api.login.JwtLogin;
import com.gow.beau.model.data.User;
import com.gow.beau.service.customer.CustomerService;
import com.gow.beau.storage.auto.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * Created by lzn on 2019/2/27.
 */
public class AuthenticationInterceptor implements HandlerInterceptor {

    @Autowired
    private CustomerService customerService;

    @Override
    public boolean preHandle(HttpServletRequest request , HttpServletResponse response , Object object) throws Exception {
        //从http请求头中取出token
        String token = request.getHeader("token");
        String value = object.toString();
        System.err.print(value);

        System.err.print(object);
        if(null != token){
            return true;
        }

        //执行认证,没有token 则跳到登陆页面
        if(token == null){
            request.getRequestDispatcher("/login/login-page").forward(request,response);
            return false;
        }

        //获取 token 中的 user id
        Long userId = JWT.decode(token).getClaim("id").asLong();
        Customer customer = customerService.selectCustomerInfoByCustomerId(userId);
        if(null == customer){
            throw new RuntimeException("用户不存在，请重新登陆");
        }

        User user = new User();
        user.setId(customer.getId());
        user.setUserName(customer.getCustomerUsername());
        user.setPassWord(customer.getCustomerPassword());
        Boolean isVerify = JwtLogin.isVerify(token,user);
        if(!isVerify){
            throw new RuntimeException("非法的访问");
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request , HttpServletResponse response , Object object , ModelAndView view) throws Exception{

    }

    @Override
    public void afterCompletion(HttpServletRequest request , HttpServletResponse response , Object object , Exception e){

    }

    /**
     * lzn 2019/3/4 9:01
     * 处理当前页面的请求path和参数
     */
    private String pathAndParameterMap(HttpServletRequest request , HttpServletResponse response){
        String url = request.getRequestURI();
        Map<String,String[]> map = request.getParameterMap();
        String pathParameter = url+"?parameter=1";
        if(null != map && map.size() > 0){
            for(String key : map.keySet()){
                String[] values = map.get(key);
                pathParameter += "&"+key+"="+values[0];
            }
        }
        return pathParameter;
    }
}
