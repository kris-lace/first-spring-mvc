package com.springapp.mvc.domain;

import org.springframework.stereotype.Component;

/**
 * Created by kristopherstevens on 12/02/15.
 */
public class Book {

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
            this.title = title;
    }

    private String title;

}
