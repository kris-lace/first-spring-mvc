package com.springapp.mvc.controller;

import com.springapp.mvc.domain.Order;
import com.springapp.mvc.service.LibraryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class HelloController {

	private LibraryService libraryService;

	@RequestMapping(value = "hello", method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {
		model.addAttribute("message", "Hello world!");
		return "hello";
	}

	@RequestMapping(value="order/{username}/{title}", method = RequestMethod.GET)
	@ResponseBody /* View */
	public String orderBook(@PathVariable("username") String username,
							@PathVariable("title") String title) {

		String console = username + " requests " + title;

		Order order = new Order();
		order.setBook(title);
		order.setUser(username);

		order = libraryService.orderBook(order);

		console.concat("\n" + order.getStatus());
		return console;
	}

	@RequestMapping(value="order/{username}/{title}", method = RequestMethod.DELETE)
	@ResponseBody /* View */
	public String returnBook(@PathVariable("username") String username,
							 @PathVariable("title") String title) {

		String console = username + " requests " + title;

		Order order = new Order();
		order.setBook(title);
		order.setUser(username);

		order = libraryService.returnBook(order);

		console.concat("\n" + order.getStatus());
		return console;
	}

	public void setService(LibraryService service) {
		this.libraryService = service;
	}

}