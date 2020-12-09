package com.cifolavioleta.springbackend.controller;

import com.cifolavioleta.springbackend.service.BookService;
import com.cifolavioleta.springbackend.model.Book;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.ResponseEntity;
//import org.springframework.ui.Model;

@RestController
@RequestMapping("/books/")
public class BookController {
	@Autowired
	private BookService bookService;
	
	@GetMapping("/all/")
	public ResponseEntity<List<Book>> getAllBooks() {
		return ResponseEntity.ok(bookService.findAll());
	}
	
	/*@GetMapping("/allBooks")
	public String getAllBooks(Model model) {
		model.addAttribute("books", bookService.findAll());
		return "allBooks";
	}*/
}
