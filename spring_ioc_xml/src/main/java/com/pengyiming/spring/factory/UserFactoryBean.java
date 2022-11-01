package com.pengyiming.spring.factory;

import com.pengyiming.spring.pojo.User;
import org.springframework.beans.factory.FactoryBean;
/*
FactoryBean是一个接口，需要创建一个类实现该接口
其中有三个方法
getObject() 通过一个对象交给ioc容器管理
getObjectType() 设置所提供对象是否单例
isSingleton(): 所提供的对象是否单例
当把FactoryBean的实现类配置为bean时，会将当前类中getObject()所返回的对象交给ioc容器管理

区别：
普通工厂，先把工厂配置给一个bean，通过工厂所对应的对象，获取工厂所以提供的对象
 */
public class UserFactoryBean implements FactoryBean<User> {
    @Override
    public User getObject() throws Exception {
        return new User();
    }

    @Override
    public Class<?> getObjectType() {
        return User.class;
    }

}
