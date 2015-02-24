package com.springapp.mvc.domain;

/**
 * Created by kristopherstevens on 12/02/15.
 */
public class Order {

    private User user;
    private Book book;
    private String status;
    private String bookRequest;

    public String getBookRequest() {
        return bookRequest;
    }

    public void setBookRequest(String bookRequest) {
        this.bookRequest = bookRequest;
    }

    public User getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = new User(user);
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
