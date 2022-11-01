package com.test.Mybatis.test;
import com.test.Mybatis.pojo.User;
import com.test.Mybatis.mappers.UserMapper;
import com.test.Mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class mybatisTest {
    @Test
    public void testInsert() throws IOException {

        //获取核心配置文件输入流
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        //获取SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        //获取SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory= sqlSessionFactoryBuilder.build(is);
        //获取sql会话对象SqlSession，mybatis提供的操作数据库的对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取UserMapper的代理实现类对象，MAPPER对应的方法
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        System.out.println(mapper);

        //调用mapper接口中的方法
//        int i;
//        for(i=0; i<10; i++){
        int result = mapper.insertUser();
        sqlSession.commit();
        System.out.println("结果:"+result);
//        }

//        List<User> result = mapper.getUserList();
//        System.out.println(result);
        sqlSession.close();
    }


    @Test
    public void testSelectAll(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = mapper.getUserList();
//        System.out.println(userList);
        userList.forEach(System.out::println);
//        sqlSession.close();

    }


    @Test
    public void testSelectById(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserById();
        System.out.println(user);
        sqlSession.close();
    }
    //    mybatis获取参数
//    单个变量
    @Test
    public void testGetUserByUsername(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserByUsername("testData");
        System.out.println(user);
    }
//      多个变量
    @Test
    public void testCheckLogin(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
//        这种方法，在mapper文件里要用arg,param的形式
        User user = mapper.checkLogin("testData","123456");
        System.out.println(user);
    }
//      用map键值对实现多个变量
    @Test
    public void testCheckLoginByMap(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Map<String,Object> map = new HashMap<>();
        map.put("username","testData");
        map.put("password","123456");
        User user = mapper.checkLoginByMap(map);
        System.out.println(user);
    }
//      使用实体类对象

    @Test
    public void testInsertUser(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User(null,"root","123456",33,"女","test@qq.com");
        mapper.insertUser(user);
    }


//  使用@param
    @Test
    public void testCheckLoginByParam(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.checkLoginByParam("root","123456");
        System.out.println(user);
    }








}
