package com.pengyiming.spring.test;

import com.pengyiming.spring.aop.Calculator;
import com.pengyiming.spring.aop.Impl.CalculatorImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AOPtest {
    @Test
    public void testAOPByAnnotation(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("aop-annotation.xml");
//         要通过代理对象,不能用目标对象,ioc容器中获取不到目标对象
//        CalculatorImpl calculator = ioc.getBean(CalculatorImpl.class);  获取不到
//        使用所继承的父类,或者接口就能获取到bean
        Calculator calculator = ioc.getBean(Calculator.class);
        calculator.div(1,1);
    }
}
