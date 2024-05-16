package com.online.bookapp.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class HomeBook {
	private String title;
	private String author;
	private String publisher;
	private String category;
	private String imageLink;
	private String bookId;
	private double rating;
	private int numberOfReviews;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getImageLink() {
		return imageLink;
	}
	public void setImageLink(String imageLink) {
		this.imageLink = imageLink;
	}
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	
	@Override
	public String toString() {
		return "HomeBook [title=" + title + ", author=" + author + ", publisher=" + publisher + ", category=" + category
				+ ", imageLink=" + imageLink + ", bookId=" + bookId + ", rating=" + rating + "]";
	}
	public int getNumberOfReviews() {
		return numberOfReviews;
	}
	public void setNumberOfReviews(int i) {
		this.numberOfReviews = i;
	}
	
	
}
