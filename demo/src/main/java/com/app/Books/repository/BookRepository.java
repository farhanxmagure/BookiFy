package com.app.Books.repository;

import com.app.Books.data.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Date;
import java.util.List;

public interface BookRepository extends MongoRepository<Book, String> {
    List<Book> findByTitleContainingIgnoreCase(String title);
    List<Book> findByGenre(String genre);
    List<Book> findByAuthor(String author);
    List<Book> findByPublicationDateBetween(Date startDate, Date endDate);
}
