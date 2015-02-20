package com.springapp.mvc;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("file:src/main/webapp/WEB-INF/mvc-dispatcher-servlet.xml")
public class AppTests {
    private MockMvc mockMvc;

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    protected WebApplicationContext wac;

    private String URL = "/library/order";

    @Before
    public void setup() {
        this.mockMvc = webAppContextSetup(this.wac).build();
    }

    @Test
    public void simple() throws Exception {
        mockMvc.perform(get("/hello"))
               .andExpect(status().isOk())
               .andExpect(view().name("hello"));
    }

    @Test
    public void testThatUserCanOrderABookThatExists() throws Exception {
        // When A User makes an order
        // With a book that's available
        // It should successfully order the book

        mockMvc.perform(get("/order/kris/BookA"))
               .andExpect(status().isOk());

    }

    @Test
    public void testThatUserCantOrderABookThatDoesNotExist() throws Exception {
        // When A User makes an order
        // With a book that's not available
        // It should respond with appropriate message order the book

        mockMvc.perform(get(URL + "/library/order/kris/BookX"))
               .andExpect(status().isOk())
               .andExpect(view().name("hello")); // TODO

    }

    @Test
    public void testThatUserCantOrderABookWhenTheyHaveABookAlready() throws Exception {
        // When A User makes an order
        // With a book that's available - but they have a book already
        // It should respond with appropriate error message

        mockMvc.perform(get(URL + "/library/order/kris/BookA")) // TODO
               .andExpect(status().isOk())
               .andExpect(view().name("hello")); // TODO

    }

    @Test
    public void testThatUsersBooksEmptyWhenReturned() throws Exception {
        // When A User returns a book
        // with a valid book
        // It should not be in their collection any more

        mockMvc.perform(delete(URL + "/library/order/kris/BookB"))
               .andExpect(status().isOk())
               .andExpect(view().name("hello")); // TODO

    }

    @Test
    public void testThatLibraryBooksAreAvailableWhenReturned() throws Exception {
        // When A User returns a book
        // with a valid book
        // It should now be available to order

        mockMvc.perform(delete(URL + "/library/order/kris/BookA"))
               .andExpect(status().isOk())
               .andExpect(view().name("hello")); // TODO

    }

}
