package com.app.Books;

import com.app.Books.data.request.BookRequest;
import com.app.Books.data.response.BookResponse;
import com.app.Books.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping
    public BookResponse addBook(@RequestBody BookRequest bookRequest) {
            return bookService.addBook(bookRequest);
    }

    @PutMapping("/{id}")
    public BookResponse updateBook(@PathVariable String id, @RequestBody BookRequest bookRequest) {
        return bookService.updateBook(id, bookRequest);
    }


    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable String id) {
        bookService.deleteBook(id);
    }

    @GetMapping
    public List<BookResponse> getBooks() {
        return bookService.getBooks();
    }

    @GetMapping("/{id}")
    public BookResponse getBookById(@PathVariable String id) {
         return bookService.getBookById(id);
    }

    @GetMapping("/search")
    public List<BookResponse> searchBooks(@RequestParam String query) {
        return bookService.searchBooks(query);
    }


    @GetMapping("/filter")
    public List<BookResponse> filterBooks(
            @RequestParam(required = false) String genre,
            @RequestParam(required = false) String author,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date startDate,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date endDate) {
        return bookService.filterBooks(genre, author, startDate, endDate);
    }

}
