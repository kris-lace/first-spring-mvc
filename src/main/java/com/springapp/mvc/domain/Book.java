package com.springapp.mvc.domain;

/**
 * Created by kristopherstevens on 12/02/15.
 */
public class Book {

    public Book(String title){
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    private String title;

}
