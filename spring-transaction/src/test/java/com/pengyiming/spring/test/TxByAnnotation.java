package com.pengyiming.spring.test;


import com.pengyiming.spring.controller.BookController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/*声明式事务的配置步骤
* 1. 在spring的配置文件中配置事务管理器
* 2. 开启事务的注解驱动
* 在需要被事务管理的方法上，添加@Transactional注解，该方法就会被事务管理
* @Transactional注解标识的位置
* 1. 标识在方法上
* 2. 标识在类上，则类中所有的方法都会被事务管理
*
* */






@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:tx-annotation.xml")
public class TxByAnnotation {

    //Bookt 可以通过装配的方式访问ioc容器中的bean
    @Autowired
    private BookController bookController;

    @Test
    public void testBuyBook(){
            // 因为设置了unsigned 所以出现结果为负数会报错
            // 默认每个sql语句各自独占一个单独的事务，所以其他事务单独执行成功不受影响
            // 库存变了，余额没变
            bookController.buyBook(1,1);

            // 应该把所有sql放到一个事务中，出现异常全部回滚
    }

}
