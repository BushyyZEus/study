package com.pengyiming.spring.test.IOCByXml;

import com.pengyiming.spring.pojo.Clazz;
import com.pengyiming.spring.pojo.Person;
import com.pengyiming.spring.pojo.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IOCByXML {
    /*
    * 获取bean的三种方式
    * 1.根据bean的id获取
    * 2.根据bean的类型获取，一般都是用类型获取
    *注意: 根据类型获取Bean时，ioc容器中有且只有一个类型匹配的bean
    * 多个bean异常：NoUniqueBeanDefinitionException
    * 没有bean异常：NoSuchBeanDefinitionException
    * 3.根据bean的id和类型
    * 根据类型来获取bean时，在满足bean唯一性的前提下，其实只是看：『对象 instanceof 指定的类
        型』的返回结果，只要返回的是true就可以认定为和类型匹配，能够获取到。
        *
        * 即通过bean的类型，bean所继承的类的类型，bean所实现的类的类型都可以获取bean
    * */

    @Test
    public void testIOC(){
//        获取ioc容器
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
//        获取bean
//        根据id获取bean
//        Student studentOne = (Student) ioc.getBean("studentOne");
//        根据类型获取bean,用的最多
//        Student studentOne = ioc.getBean(Student.class);
//        根据类型和id
//        Student studentOne = ioc.getBean("studentOne",Student.class);
        Person studentOne = ioc.getBean(Person.class);
        System.out.println(studentOne);
    }
//依赖注入有两种方式
//    set注入

    @Test
    public void testDI1(){

        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
        Student studentTwo = ioc.getBean("studentTwo", Student.class);
        System.out.println(studentTwo);

    }
    //    构造器注入，有参构造
    @Test
    public void testDI2(){

        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
        Student studentFour = ioc.getBean("studentFour", Student.class);
        System.out.println(studentFour);

    }
//引用类类型，引用外部的bean
    @Test
    public void testDIClazz(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
//        Student student = ioc.getBean("studentFive",Student.class);
        Student student = ioc.getBean("studentSix",Student.class);
        System.out.println(student);

    }
//    报错，内部bean不能由IOC容器直接获取
    @Test
    public void testDIClazz2(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
        Clazz clazz = ioc.getBean("clazzInner", Clazz.class);
        System.out.println(clazz);
    }

//    列表类型
    @Test
    public void testDIClazzlist(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
        Clazz clazz = ioc.getBean("clazzOne",Clazz.class);
        System.out.println(clazz);

    }


}
