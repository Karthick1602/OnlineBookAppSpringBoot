package com.online.bookapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.online.bookapp.domain.Review;
import com.online.bookapp.repository.ReviewRepository;
import com.online.bookapp.service.ReviewService;

@RestController
public class ReviewController {
	
	@Autowired
	public ReviewService reviewService;
	
	@Autowired
	private ReviewRepository reviewRepository;
	
	@PostMapping("/reviews")
	public ResponseEntity<List<Review>> writeReview(@RequestBody List<Review> reviews)
	{   
		for(Review review : reviews)
		{
			reviewRepository.save(review);
		}
		return new ResponseEntity<>(reviews, HttpStatus.CREATED);
		
	}
	
	@GetMapping("/reviews")
	public ResponseEntity<List<Review>> getAllReviews()
	{
		List<Review> reviews = reviewRepository.findAll();
		return new ResponseEntity<>(reviews, HttpStatus.OK);
	}
	
	@GetMapping("/reviews/{_id}")
	public ResponseEntity<Review> getReviewsById(@PathVariable String _id)
	{
		Optional<Review> review = reviewRepository.findById(_id);
		return new ResponseEntity<>(review.get(), HttpStatus.OK);	
	}
	
	@GetMapping("/reviews/book/{bookId}")
	public ResponseEntity<List<Review>> getReviewsByBookId(@PathVariable String bookId)
	{
		List<Review> reviews = reviewService.getAllReviewsByBookId(bookId);
		return new ResponseEntity<>(reviews, HttpStatus.OK);
	}
	
	@DeleteMapping("/reviews/{_id}")
	public ResponseEntity<Void> deleteReviewsById(@PathVariable String _id)
	{   
		reviewRepository.deleteById(_id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping("/reviews")
	public ResponseEntity<Void> deleteAllReviews()
	{   
		reviewRepository.deleteAll();
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}