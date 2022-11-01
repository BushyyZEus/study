package com.pengyiming.spring.dao.Impl;

import com.pengyiming.spring.dao.UserDao;

public class UserDaoImpl implements UserDao {

    @Override
    public void saveUser(){
        System.out.println("已保存");
    }
}
