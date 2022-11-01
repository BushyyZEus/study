package com.pengyiming.spring.service.Impl;

import com.pengyiming.spring.dao.UserDao;
import com.pengyiming.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    @Override
    public void saveUser(){
        userDao.saveUser();
    }
}
