package com.online.bookapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.online.bookapp.domain.Review;
import com.online.bookapp.repository.ReviewRepository;

@Service
public class ReviewService {
	
	@Autowired
	public ReviewRepository reviewRepository;
	
	public List<Review> getAllReviewsByBookId(String bookId)
	{   
		List<Review> reviews = reviewRepository.findAll();
//		List<Review> reviewsByBookId = new ArrayList<Review>();
//		for(Review review : reviews)
//		{
//			if(review.getBookId().equalsIgnoreCase(bookId))
//			{
//				reviewsByBookId.add(review);
//			}
//		}
//		return reviewsByBookId;
//	}
	    // Java 8 Code
		List<Review> reviewsByBookId = reviews.stream()
				.filter(s ->s.getBookId().equalsIgnoreCase(bookId))
				.collect(Collectors.toList());
		return reviewsByBookId;
	}
}
