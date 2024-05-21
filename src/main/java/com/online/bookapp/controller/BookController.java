package com.online.bookapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.online.bookapp.domain.Book;
import com.online.bookapp.repository.BookRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200") // To resolve CORS error in Angular(No 'Access-Control-Allow-Origin' header is present on the requested resource.)
public class BookController {
	
	@Autowired
	private BookRepository bookRepository;
	
//	@GetMapping("/books")
//	public ResponseEntity<List<Book>> getAllBooks()
//	{
//		List<Book> books = bookRepository.findAll();
//		return new ResponseEntity<>(books, HttpStatus.OK);
//	}
	@GetMapping("/books")
	 public ResponseEntity<Page<Book>> getAllBooks(Pageable pageable) {
		Page<Book> books = bookRepository.findAll(pageable);
		return new ResponseEntity<>(books, HttpStatus.OK);
	    }
	
	@GetMapping("/books/{_id}")
	public ResponseEntity<Book> getBookById(@PathVariable String _id)
	{   
		Optional<Book> book = bookRepository.findById(_id);
		return new ResponseEntity<>(book.get(), HttpStatus.OK);
	}
	
	@PostMapping("/books/create")
	public ResponseEntity<Book> createBook(@RequestBody Book book) {
		
			bookRepository.save(book);
		return new ResponseEntity<>(book, HttpStatus.OK);
	}
	
	@PostMapping("/books")
	public ResponseEntity<List<Book>> createBooks(@RequestBody List<Book> books) {
		for (Book book : books) {
			bookRepository.save(book);
		}
		return new ResponseEntity<>(books, HttpStatus.OK);
	}
	
	@DeleteMapping("/books/{_id}")
	public ResponseEntity<Void> deleteBookById(@PathVariable String _id)
	{
		bookRepository.deleteById(_id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping("/books")
	public ResponseEntity<Void> deleteAllBooks() 
	{
		bookRepository.deleteAll();
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}