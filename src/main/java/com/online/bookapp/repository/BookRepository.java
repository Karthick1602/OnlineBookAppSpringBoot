package com.online.bookapp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.online.bookapp.domain.Book;

public interface BookRepository extends MongoRepository<Book, String> {

}
