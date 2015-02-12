package com.springapp.mvc.domain;

/**
 * Created by kristopherstevens on 12/02/15.
 */
public class Order {

    private User user;
    private Book book;
    private String status;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
