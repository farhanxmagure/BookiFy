package com.app.Books.data.response;

import com.app.Books.data.Book;
import lombok.Data;

import java.util.Date;

@Data
public class BookResponse {
    private String id;
    private String title;
    private String author;
    private String genre;
    private Date publicationDate;

    public BookResponse(Book book) {
        this.id = book.getId();
        this.title = book.getTitle();
        this.author = book.getAuthor();
        this.genre = book.getGenre();
        this.publicationDate = book.getPublicationDate();
    }
}
