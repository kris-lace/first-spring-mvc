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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
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
        /*  When A User makes an order
            With a book that's available
            It should successfully order the book */

        mockMvc.perform(get("/order/kris/Book_A"))
               .andExpect(status().isOk())
               .andExpect(content().string("kris requests Book_A\n" + "Successfully ordered Book_A"));
    }

    @Test
    public void testThatUserCantOrderABookThatDoesNotExist() throws Exception {
        /*  When A User makes an order
            With a book that's not available
            It should respond with appropriate message order the book */

        mockMvc.perform(get("/order/kris/Book_X"))
               .andExpect(status().isOk())
               .andExpect(content().string("kris requests Book_X\n" + "Book not found"));
    }

    @Deprecated // TODO
    public void testThatUserCantOrderABookWhenTheyHaveABookAlready() throws Exception {
        /*  When A User makes an order
            With a book that's available - but they have a book already
            It should respond with appropriate error message */

        mockMvc.perform(get("/order/kris/Book_A"))
               .andExpect(status().isOk());

        mockMvc.perform(get("/order/kris/Book_B"))
               .andExpect(status().isOk())
               .andExpect(content().string("kris requests Book_X\n" + "Book not found"));
    }

    @Deprecated // TODO
    public void testThatUsersBooksEmptyWhenReturned() throws Exception {
        /*  When A User returns a book
            with a valid book
            It should not be in their collection any more */

        mockMvc.perform(delete("/order/kris/Book_B"))
               .andExpect(status().isOk())
               .andExpect(content().string("kris requests Book_X\n" + "Book not found"));
    }

    @Deprecated // TODO
    public void testThatLibraryBooksAreAvailableWhenReturned() throws Exception {
        /*  When A User returns a book
            with a valid book
            It should now be available to order */

        mockMvc.perform(delete("/order/kris/BookA"))
               .andExpect(status().isOk())
               .andExpect(view().name("hello"));
    }
}
