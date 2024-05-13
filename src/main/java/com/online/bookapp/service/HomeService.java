package com.online.bookapp.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;

import com.online.bookapp.domain.Book;
import com.online.bookapp.domain.HomeBook;
import com.online.bookapp.domain.Review;
import com.online.bookapp.repository.BookRepository;
import com.online.bookapp.repository.ReviewRepository;

import lombok.Builder;

@Service

public class HomeService {

	@Autowired
	public ReviewRepository reviewRepository;
	
	@Autowired
	public BookRepository bookRepository;
	
	public Page<HomeBook> getHomeBookList(Pageable pageable) {
	    // Fetch a page of books from the database
	    Page<Book> books = this.bookRepository.findAll(pageable);
	    
	    // Fetch all reviews from the database (assuming they are not paginated)
	    List<Review> reviews = this.reviewRepository.findAll();
	    
	    List<HomeBook> homeBookList = new ArrayList<>();

	    for (Book book : books) {
	        HomeBook homeBook = new HomeBook();
	        List<Double> ratings = new ArrayList<>();

	        homeBook.setBookId(book.get_id());
	        homeBook.setAuthor(book.getAuthor());
	        homeBook.setCategory(book.getCategory());
	        homeBook.setImageLink(book.getImageLink());
	        homeBook.setTitle(book.getTitle());
	        homeBook.setPublisher(book.getAuthor());

	        for (Review review : reviews) {
	            if (review.getBookId().equalsIgnoreCase(book.get_id())) {
	                ratings.add(review.getRating());
	            }
	        }

	        homeBook.setRating(getAverageRating(ratings));
	        homeBookList.add(homeBook);
	    }

	    return new PageImpl<>(homeBookList, pageable, this.bookRepository.count());
	}



	private double getAverageRating(List<Double> ratings) {
		// TODO Auto-generated method stub
		double sum = 0.0;
        for (Double rating : ratings) {
            sum += rating;
        }
        double average =0.0;
        // Calculate the average
        if(sum>1.0) {
        average= sum / ratings.size();
        }
        else {
        	average=0.0;
        }
		return average;	
	}
}
