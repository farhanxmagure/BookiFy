package com.app.Books.service;

import com.app.Books.data.Book;
import com.app.Books.data.request.BookRequest;
import com.app.Books.data.response.BookResponse;
import com.app.Books.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public BookResponse addBook(BookRequest bookRequest) {
        Book book = new Book();
        book.setTitle(bookRequest.getTitle());
        book.setAuthor(bookRequest.getAuthor());
        book.setGenre(bookRequest.getGenre());
        book.setPublicationDate(bookRequest.getPublicationDate());
        bookRepository.save(book);
        return new BookResponse(book);
    }

    public BookResponse updateBook(String id, BookRequest bookRequest) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
        book.setTitle(bookRequest.getTitle());
        book.setAuthor(bookRequest.getAuthor());
        book.setGenre(bookRequest.getGenre());
        book.setPublicationDate(bookRequest.getPublicationDate());
        bookRepository.save(book);
        return new BookResponse(book);
    }

    public void deleteBook(String id) {
        bookRepository.deleteById(id);
    }

    public List<BookResponse> getBooks() {
        return bookRepository.findAll().stream().map(BookResponse::new).collect(Collectors.toList());
    }

    public BookResponse getBookById(String id) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
        return new BookResponse(book);
    }

    public List<BookResponse> searchBooks(String query) {
        return bookRepository.findByTitleContainingIgnoreCase(query).stream().map(BookResponse::new).collect(Collectors.toList());
    }

    public List<BookResponse> filterBooks(String genre, String author, Date startDate, Date endDate) {
        List<Book> books;

        if (genre != null) {
            books = bookRepository.findByGenre(genre);
        } else if (author != null) {
            books = bookRepository.findByAuthor(author);
        } else if (startDate != null && endDate != null) {
            books = bookRepository.findByPublicationDateBetween(startDate, endDate);
        } else {
            books = bookRepository.findAll();
        }

        return books.stream().map(BookResponse::new).collect(Collectors.toList());
    }
}
