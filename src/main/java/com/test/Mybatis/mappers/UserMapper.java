package com.test.Mybatis.mappers;

import com.test.Mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    int insertUser();

    List<User> getUserList();

//    User getUserById(@Param("id") int id);
    User getUserById();
//    单个变量
    User getUserByUsername(String username);
//    多个变量
    User checkLogin(String username,String password);
//    用map自定义键值对实现多个变量，不需要param,arg
    User checkLoginByMap(Map<String, Object> map);
//    接口中用实体类对象
    void insertUser(User user);
//    @Param
//    两种方式存储
//    以@Param注解的value为键，以参数为值
//    以param1,param2...为键
    //                                  key                value              key            value
    //不需要手动添加map
    User checkLoginByParam(@Param("username") String username,@Param("password") String password);











}
