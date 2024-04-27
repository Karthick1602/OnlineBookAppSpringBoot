package com.online.bookapp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.online.bookapp.domain.Review;

public interface ReviewRepository extends MongoRepository<Review, String> {

}
