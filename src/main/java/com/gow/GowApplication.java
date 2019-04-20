package com.gow;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


@MapperScan(value = {"com.gow.beau.storage.auto.mapper", "com.gow.beau.storage.ext.mapper"})
@SpringBootApplication
public class GowApplication extends SpringBootServletInitializer{

    public static void main(String[] args) {
        SpringApplication.run(GowApplication.class, args);
    }

    /**
     * lzn 2019/3/31 16:43
     * 重写方法，为了jar打包
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder){
        return builder.sources(this.getClass());
    }


}

