package com.springapp.mvc.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kristopherstevens on 12/02/15.
 */
public class User {

    private String name;

    private List<Book> books;

    public User(String name) {
        this.name = name;
    }

    public User() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addBook(Book book) {
        if (books == null) books = new ArrayList<Book>();
        books.add(book);
    }

    public void removeBook(Book book) {
        books.remove(book);
    }

    public List<Book> getBooks() {
        return books;
    }

}
