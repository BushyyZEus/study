package com.pengyiming.spring.test.IOCByXml;

import com.pengyiming.spring.controller.UserController;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AutowireByXMLTest {
/*
* 自动装配
* 根据指定的策略，在ioc容器中匹配某个bean，自动为bean中的类类型的属性或接口类型的属性赋值
* 可以通过bean标签的autowire属性设置自动装配的策略
* 只能自动装配类类型，不能装配字面量
*
* 自动装配的策略：
* no, default： 表示不装配，即bean中的属性不会自动装配某个bean为属性赋值，此时属性使用默认值
* byType 根据要赋值的属性的类型，在IOC容器中匹配某个bean，自动去ioc容器找到类型注入
* 注意：
* 1. 若通过类型没有找到类型匹配的bean，此时就不装配，属性使用默认值（null或创建时赋值）
* 2. 若通过类型找到了多个类型匹配的bean，此时会抛出异常
* 总结：bytype实现自动装配时，IOC容器中有且仅有一个类型匹配的bean能够为属性赋值
*
* byName 将要赋值的属性的属性名作为bean的id在ioc容器中匹配某个bean，为属性赋值
* 总结：当类型匹配的bean有多个时，此时可以使用byName实现自动装配
* */
    @Test
    public void testAutoWire(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-autowire-xml.xml");
        UserController userController = ioc.getBean(UserController.class);
//        springMVC 会封装servelet 会帮你访问controller
//        这里是模拟
        userController.saveUser();
    }
}
