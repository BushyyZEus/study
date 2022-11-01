package com.pengyiming.spring.service.Impl;


import com.pengyiming.spring.dao.BookDao;
import com.pengyiming.spring.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;

    @Override
    @Transactional(
//            readOnly = true  // 只读，只有查询操作使用，优化查询效率，默认false
//            timeout = 3         // 超时回滚，释放资源，抛出异常 默认-1 表示一直等，设置3 为等3秒
//            声明式事务默认只针对运行时异常回滚，编译时异常不回滚
//            rollbackForClassName
//            rollbackFor
//            noRollbackForClassName  = ArithmeticException.class          不因为什么回滚
//            noRollbackForClassName
//

//            事务隔离级别，根据sql的事务隔离级别标准，处理并发问题
//            事务传播行为，当事务方法被另一个事务方法调用时，必须指定事务应该如何传播。
    )
    public void buyBook(Integer userId, Integer bookId) {
        //查询图书价格
        Integer price = bookDao.getPriceByBookId(bookId);
        //更新图书的库存
        bookDao.updateStock(bookId);
        //更新用户的余额
        bookDao.updateBalance(userId,price);
//        System.out.println(1/0);
    }
}
