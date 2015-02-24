package com.springapp.mvc.repository;

import com.springapp.mvc.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kristopherstevens on 12/02/15.
 */
public class RepositoryMemImpl implements Repository {

    private List<Book> books;

    @Override
    public Book findBook(String searchTitle) {

        /* TODO - revisit with java 8 in mind ;D  */

        System.out.println(books.size());

        for (int i = 0 ; i < books.size(); i++){

            Book book = books.get(i);

            if (book.getTitle().equals(searchTitle)) {
                books.remove(book);
                return book;
            }

        }
        return null;
    }

    @Override
    public boolean returnBook(Book book) {
        return books.add(book);
    }

    public List<Book> getBooks() {
        return books;
    }


    public void setBooks(List<Book> books) {
        this.books = books;
    }

}
