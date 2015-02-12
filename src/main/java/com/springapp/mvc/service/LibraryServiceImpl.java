package com.springapp.mvc.service;

import com.springapp.mvc.domain.User;
import com.springapp.mvc.repository.Repository;
import com.springapp.mvc.domain.Book;
import com.springapp.mvc.domain.Order;
import org.springframework.beans.factory.annotation.Required;

/**
 * Created by kristopherstevens on 12/02/15.
 */
public class LibraryServiceImpl implements LibraryService {

    Repository library;

    @Override
    public Order orderBook(Order order) {

        if (validateOrder(order)) {
            order.setBook(library.findBook(order.getBook().getTitle()));

            if (order.getBook() != null) {
                order.setStatus("successfully ordered " + order.getBook().getTitle());
            } else {
                order.setStatus("book not found");
            }

            return order;
        } else {
            return order;
        }

    }

    @Override
    public void returnBook(Book book) {
        library.returnBook(book);
    }

    private boolean validateOrder(Order order) {

        if (order.getUser().getBooks().size() > 1) {
            order.setStatus("You can't order a new book until you return your current one.");
            return false;
        } else {
            order.setStatus("Order valdiated");
            return true;
        }
    }

    @Override
    public User newUser(String name){
        return new User(name);
    }

    @Required
    public void setLibrary(Repository library) {
        this.library = library;
    }
}
