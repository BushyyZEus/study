package com.test.Mybatis.test;

import com.test.Mybatis.mappers.SelectMapper;
import com.test.Mybatis.mappers.UserMapper;
import com.test.Mybatis.pojo.User;
import com.test.Mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class SelectMapperTest {

// 按照Id单独查询
    @Test
    public void testGetUserById(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        User user = mapper.getUserById(10);
        System.out.println(user);
    }
// 查询返回列表，用forEach 打印
    @Test
    public void testGetAllUser(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        List<User> list = mapper.getAllUser();
        list.forEach(System.out::println);

    }
//   返回整数
    @Test
    public void testGetCount(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        Integer count = mapper.getCount();
        System.out.println(count);

    }

    // 返回map
//    {password=123456, gender=男, id=10, age=23, email=12345@qq.com, username=admin}
//    如果查询的数据中，某个值为null, 那么相对应的键值对不会出现在map中
    @Test
    public void testGetUserByIdToMap(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        Map<String,Object> map = mapper.getUserByIdToMap(10);
        System.out.println(map);
        
    }

    @Test
    public void testGetAllUserToMap() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        List<Map<String, Object>> list = mapper.getAllUserToMap();
        System.out.println(list);
    }
//    {7={password=123456, gender=男, id=7, age=23, email=12345@qq.com, username=admin},
//    8={password=123456, gender=男, id=8, age=23, email=12345@qq.com, username=admin},
//    9={password=123456, gender=男, id=9, age=23, email=12345@qq.com, username=admin},
//    10={password=123456, gender=男, id=10, age=23, email=12345@qq.com, username=admin},
//    11={password=123456, gender=男, id=11, age=23, email=12345@qq.com, username=admin},
//    12={password=123456, gender=男, id=12, age=23, email=12345@qq.com, username=admin}, 13={password=123456, gender=男, id=13, age=23, email=12345@qq.com, username=admin}, 14={password=123456, gender=男, id=14, age=23, email=12345@qq.com, username=admin}, 15={password=123456, gender=男, id=15, age=23, email=12345@qq.com, username=admin}, 16={password=123456, gender=男, id=16, age=23, email=12345@qq.com, username=admin}, 17={password=123456, gender=男, id=17, age=23, email=12345@qq.com, username=admin}, 18={password=123456, gender=男, id=18, age=23, email=12345@qq.com, username=admin}, 19={password=123456, gender=男, id=19, age=23, email=12345@qq.com, username=admin}, 20={password=123456, gender=男, id=20, age=23, email=12345@qq.com, username=admin}, 21={password=123456, gender=男, id=21, age=23, email=12345@qq.com, username=testData}, 22={password=123456, gender=男, id=22, age=23, email=12345@qq.com, username=testData}, 23={password=123456, gender=男, id=23, age=23, email=12345@qq.com, username=testData}, 24={password=123456, gender=女, id=24, age=33, email=test@qq.com, username=root}}
    //使用mapkey
    //讲查询到的map数据放到大的map，以设置的mapkey为key,其他字段为value

    @Test
    public void testGetUserByIdToMapKey() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        Map<String, Object> map = mapper.getUserByIdToMapKey();
        System.out.println(map);
    }

    @Test
    public void testGetUserByLike(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        List<User> list = mapper.getUserByLike("test");
        list.forEach(System.out::println);
    }

}
