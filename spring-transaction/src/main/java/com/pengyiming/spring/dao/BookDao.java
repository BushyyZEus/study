package com.pengyiming.spring.dao;

public interface BookDao {

    //根据图书ID查询价格
    Integer getPriceByBookId(Integer bookId);
    //更新库存
    void updateStock(Integer bookId);
    //更新余额
    void updateBalance(Integer userId, Integer price);
}
