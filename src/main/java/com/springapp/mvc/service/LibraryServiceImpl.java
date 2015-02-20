package com.springapp.mvc.service;

import com.springapp.mvc.domain.User;
import com.springapp.mvc.repository.Repository;
import com.springapp.mvc.domain.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Component;

/**
 * Created by kristopherstevens on 12/02/15.
 */
public class LibraryServiceImpl implements LibraryService {

    Repository library;

    @Override
    public Order orderBook(Order order) {

        if (validateOrder(order)) {
            order.setBook(library.findBook(order.getBook().getTitle()).getTitle());

            if (order.getBook() != null) {
                order.setStatus("Successfully ordered " + order.getBook().getTitle());
            } else {
                order.setStatus("Book not found");
            }

            return order;

        } else {
            return order;
        }

    }

    @Override
    public Order returnBook(Order order) {
        if (library.returnBook(order.getBook())) {
            order.setStatus(order.getBook().getTitle() + " returned ");
            return order;
        } else {
            order.setStatus("Problem returning " + order.getBook().getTitle());
            return order;
        }
    }

    private boolean validateOrder(Order order) {

        if (order.getUser().getBooks().size() > 1) {
            order.setStatus("You can't order a new book until you return your current one.");
            return false;
        } else {
            order.setStatus("Order validated");
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
