package com.gow.beau.autowired;

import com.gow.beau.pathpatterns.AddPathPatterns;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created by lzn on 2019/2/27.
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer{

    //拦截所有请求，通过判断是否有 @LoginRequired 注解 决定是否需要登陆
    @Override
    public void addInterceptors(InterceptorRegistry registry){
        /*registry.addInterceptor(authenticationInterceptor())
                .addPathPatterns(AddPathPatterns.addPathPatterns());*/
    }

    @Bean
    public AuthenticationInterceptor authenticationInterceptor(){
        return new AuthenticationInterceptor();
    }
}
