package com.springapp.mvc.repository;

import com.springapp.mvc.domain.Book;
import org.springframework.beans.factory.annotation.Required;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kristopherstevens on 12/02/15.
 */
public class MemoryLibrary implements Repository {

    private List<Book> books;

    @Override
    public Book findBook(String searchTitle) {
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
    public void returnBook(Book book) {
        books.add(book);
    }

    public List<Book> getBooks() {
        return books;
    }

    @Required
    public void setBooks(List<Book> books) {
        this.books = books;
    }

}
