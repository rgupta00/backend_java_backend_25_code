package com.bookapp.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "books")
public class Book {
    @Id
    private String id;
    private String name;
    private Integer pages;
    private String author;
    private Double cost;

    public Book(String name, Integer pages, String author, Double cost) {
        this.name = name;
        this.pages = pages;
        this.author = author;
        this.cost = cost;
    }
}
