package com.pengyiming.spring.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;



// 切面的优先级
@Component
@Aspect
@Order(1) //设置优先级,设置value属性,数字越小,优先级最高
public class ValidateAspect {

    @Before("com.pengyiming.spring.aop.LoggerAspect.pointCut()")
    public void beforeMethod(){
        System.out.println("ValidateAspect --> 前置通知");

    }
}
