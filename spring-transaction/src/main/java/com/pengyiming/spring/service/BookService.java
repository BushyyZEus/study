package com.pengyiming.spring.service;

import org.springframework.stereotype.Service;


public interface BookService {
    void buyBook(Integer userId, Integer bookId);
}
