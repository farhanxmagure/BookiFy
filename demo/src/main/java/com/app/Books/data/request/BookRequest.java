package com.app.Books.data.request;


import lombok.Data;
import java.util.Date;

@Data
public class BookRequest {
    private String title;
    private String author;
    private String genre;
    private Date publicationDate;
    // Additional fields
}
