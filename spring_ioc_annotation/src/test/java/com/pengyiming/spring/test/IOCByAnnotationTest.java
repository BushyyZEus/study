package com.pengyiming.spring.test;

import com.pengyiming.spring.controller.UserController;
import com.pengyiming.spring.dao.UserDao;
import com.pengyiming.spring.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IOCByAnnotationTest {
/*
* @Component：将类标识为普通组件
* 下面三个由@Component扩展出来的
* @Controller：将类标识为控制层组件
* @Service：将类标识为业务层组件
* @Repository：将类标识为持久层组件
* 不属于三层，用@Component
* 不能把这些注解放在接口里,要放在实现类
*
*
* 扫描能够把加了注解的类作为组件进行管理，就是在ioc容器加上类对应的bean对象
*
*
* 通过注解+扫描所配置的bean的id，默认值为类的小驼峰，类名首字母为小写
* 可以在注解上直接修改value值修改id名
* 一般是用类型
*
*
* @Autowired: 实现自动装配功能的注解
* @Autrowired 注解能够标识的位置
* 1、标识在成员变量上，此时不需要设置成员变量的set方法   常用
* 2、标识在set方法上
* 3、为当前成员变量赋值的有参构造上
*
* 如何实现自动装配的
* 默认通过byType方法，在ioc容器中匹配类，通过类型匹配某个bean为属性赋值
* 如果有多个类型匹配的bean，此时会自动转换为byName
*
* 如果byName和byType都不行，添加注解Qualifier，指定某个bean的id
*
* */

    @Test
    public void test(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-ioc-annotation.xml");
        UserController userController = ioc.getBean("controller",UserController.class);
//        System.out.println(userController);
//        UserService userService = ioc.getBean("userServiceImpl",UserService.class); //获取bean可以用接口类型
//        System.out.println(userService);
//        UserDao userDao = ioc.getBean("userDaoImpl",UserDao.class);
//        System.out.println(userDao);
        userController.saveUser();
        
    }
}
