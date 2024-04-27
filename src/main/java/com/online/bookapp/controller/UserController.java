package com.online.bookapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.online.bookapp.domain.User;
import com.online.bookapp.repository.UserRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200") // To resolve CORS error in Angular(No 'Access-Control-Allow-Origin' header is present on the requested resource.)
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/users")
	public ResponseEntity<List<User>> getAllUsers()
	{  
		List<User> users = userRepository.findAll();
		return new ResponseEntity<>(users, HttpStatus.OK);	
	}
	
	@GetMapping("/users/{_id}")
	public ResponseEntity<User> getUserById(@PathVariable String _id)
	{   
		Optional<User> user = userRepository.findById(_id);
		return new ResponseEntity<>(user.get(), HttpStatus.OK);	
	}
	
	@PostMapping("/users")
	public ResponseEntity<List<User>> createUsers(@RequestBody List<User> users)
	{   
		for(User user : users)
		{
			userRepository.save(user);
		}
		return new ResponseEntity<>(users, HttpStatus.CREATED);
	}

	@DeleteMapping("/users")
	public ResponseEntity<Void> deleteAllUsers()
	{   
		userRepository.deleteAll();
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping("/users/{_id}")
	public ResponseEntity<Void> deleteById(@PathVariable String _id)
	{   
		userRepository.deleteById(_id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}