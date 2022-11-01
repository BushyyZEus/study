package com.pengyiming.spring.test.IOCByXml;

import com.pengyiming.spring.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LifecycleTest {
/*
单例模式下，获取ioc容器时执行，直接创建bean对象
* 生命周期四个阶段：
* 1.实例化
* 2.依赖注入
* 3.初始化
* 4.IOC容器关闭时销毁


若bean的作用域为单例时，生命周期的前三个步骤会在获取ioc容器时执行
若bean的作用域为多例时，生命周期的前三个步骤会在获取bean时执行

* */
    @Test
    public void test(){
//        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-lifecycle.xml");
//        ConfigurableApplicationContext是ApplicationContext的子接口，添加了刷新和关闭方法
        ConfigurableApplicationContext ioc = new ClassPathXmlApplicationContext("spring-lifecycle.xml");
        User user = ioc.getBean(User.class);
        System.out.println(user);
        ioc.close();
//        ioc 容器关闭时销毁
//        ApplicationContext 没有刷新和关闭方法，要么用ConfigurableApplicationContext,要么用实现类ClassPathXmlApplicationContext
    }
}
