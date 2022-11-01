package com.pengyiming.spring.process;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        // 此方法在bean的生命周期初始化之前执行
//        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
        System.out.println("初始化之前运行");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        // 此方法在bean的生命周期初始化之后执行
//        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
        System.out.println("初始化之后运行");
        return bean;
    }
}
