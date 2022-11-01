package com.pengyiming.proxy;

import com.pengyiming.spring.proxy.Calculator;
import com.pengyiming.spring.proxy.CalculatorStaticProxy;
import com.pengyiming.spring.proxy.Impl.CalculatorImpl;
import com.pengyiming.spring.proxy.ProxyFactory;
import org.junit.Test;

public class ProxyTest {

    @Test
    public void testProxy(){
//        CalculatorStaticProxy proxy = new CalculatorStaticProxy(new CalculatorImpl());
//        proxy.add(1,2);
        ProxyFactory proxyFactory = new ProxyFactory(new CalculatorImpl());
        Calculator proxy = (Calculator) proxyFactory.getProxy();
        proxy.add(1,2);
    }
}
