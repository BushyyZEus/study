package com.pengyiming.spring.test.IOCByXml;

import com.pengyiming.spring.pojo.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ScopeTest {

    @Test
    public void testScope(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-scope.xml");
        Student student1 = ioc.getBean(Student.class);
        Student student2 = ioc.getBean(Student.class);
//      判断两个实例用equals，或者等号==,
//         重新toString后，对判断相等有影响
        System.out.println(student1.equals(student2));
//        返回true,因为默认是单例模式
//        多例模式配置prototype

    }
}
