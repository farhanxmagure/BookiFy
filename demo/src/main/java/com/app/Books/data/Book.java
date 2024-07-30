package com.app.Books.data;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document(collection = "books")
public class Book {
    @Id
    private String id;
    private String title;
    private String author;
    private String genre;
    private Date publicationDate;
}
