package com.springapp.mvc.repository;

import com.springapp.mvc.domain.Book;

/**
 * Created by kristopherstevens on 12/02/15.
 */
public interface Repository {

    public Book findBook(String title);

    public boolean returnBook(Book book);

}
