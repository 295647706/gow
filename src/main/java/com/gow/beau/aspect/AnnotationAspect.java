package com.gow.beau.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * Created by lzn on 2019/3/15.
 * AOP
 */
@Aspect
@Configuration
public class AnnotationAspect {

    /**
     * lzn 2019/3/15 8:19
     * 定义前置通知处理
     */
    @Before("execution(* com.gow.beau.api.*.*(..))")
    public void before(JoinPoint point){
        String mathName = point.getSignature().getName();
        Object[] objects = point.getArgs();
        System.err.println("math-->"+mathName);
        System.err.println("objects-->"+objects);
    }
}
