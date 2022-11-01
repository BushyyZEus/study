package com.test.Mybatis.mappers;

import com.test.Mybatis.pojo.User;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 *
 */
public interface SelectMapper {
    User getUserById(@Param("id") Integer id);

    List<User> getAllUser();

    Integer getCount();

//    在大部分情况下，查询到的数据没有对应的实体类，就要用map接受键值对数据
//    在没有实体类的情况下也可以查询，在得到的map中，以查到的字段名为key,查到相应字段的值为value
    Map<String,Object> getUserByIdToMap(@Param("id") Integer id);

    //查询有多条数据,并且需要map
    //1, 用lise泛型map
//    {password=123456, gender=男, id=10, age=23, email=12345@qq.com, username=admin},{password=123456, gender=男, id=10, age=23, email=12345@qq.com, username=admin}
    //2.用mapkey
//    {7={password=123456, gender=男, id=7, age=23, email=12345@qq.com, username=admin},
//    8={password=123456, gender=男, id=8, age=23, email=12345@qq.com, username=admin},
//    9={password=123456, gender=男, id=9, age=23, email=12345@qq.com, username=admin},
//    10={password=123456, gender=男, id=10, age=23, email=12345@qq.com, username=admin},
//    11={password=123456, gender=男, id=11, age=23, email=12345@qq.com, username=admin},
//    12={password=123456, gender=男, id=12, age=23, email=12345@qq.com, username=admin}, 13={password=123456, gender=男, id=13, age=23, email=12345@qq.com, username=admin}, 14={password=123456, gender=男, id=14, age=23, email=12345@qq.com, username=admin}, 15={password=123456, gender=男, id=15, age=23, email=12345@qq.com, username=admin}, 16={password=123456, gender=男, id=16, age=23, email=12345@qq.com, username=admin}, 17={password=123456, gender=男, id=17, age=23, email=12345@qq.com, username=admin}, 18={password=123456, gender=男, id=18, age=23, email=12345@qq.com, username=admin}, 19={password=123456, gender=男, id=19, age=23, email=12345@qq.com, username=admin}, 20={password=123456, gender=男, id=20, age=23, email=12345@qq.com, username=admin}, 21={password=123456, gender=男, id=21, age=23, email=12345@qq.com, username=testData}, 22={password=123456, gender=男, id=22, age=23, email=12345@qq.com, username=testData}, 23={password=123456, gender=男, id=23, age=23, email=12345@qq.com, username=testData}, 24={password=123456, gender=女, id=24, age=33, email=test@qq.com, username=root}}


    List<Map<String,Object>> getAllUserToMap();


    @MapKey("id")
    Map<String,Object> getUserByIdToMapKey();


//    模糊查询

    List<User> getUserByLike(@Param("mohu") String mohu);


}
