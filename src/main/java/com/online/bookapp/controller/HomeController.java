package com.online.bookapp.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.online.bookapp.domain.HomeBook;
import com.online.bookapp.service.HomeService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class HomeController {

	@Autowired
	public HomeService homeService;
	
	@GetMapping("/home")
	public ResponseEntity<Page<HomeBook>> getAllBookList(Pageable pageable){
		Page<HomeBook> bookList = this.homeService.getHomeBookList(pageable);
		return new ResponseEntity<>(bookList,HttpStatus.OK);		
	}
	
	
	
}
