package com.springapp.mvc.service;

import com.springapp.mvc.domain.Book;
import com.springapp.mvc.domain.Order;
import com.springapp.mvc.domain.User;

/**
 * Created by kristopherstevens on 12/02/15.
 */
public interface LibraryService {

    public Order orderBook(Order order);

    public Order returnBook(Order order);

    public User newUser(String name);

}
