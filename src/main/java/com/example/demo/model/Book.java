package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter 
@Setter 
@NoArgsConstructor 
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank(message = "Title can not be empty")
    private String title;
    @NotBlank
    private String author;
    @NotBlank
    private String discription;
    @Positive
    private double price;


    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public Book(String title, String author, String discription, double price) {
        this.title = title;
        this.author = author;
        this.discription = discription;
        this.price = price;
    }
     @OneToMany(mappedBy="book")
    private List<BorrowRecord>borrowRecord=new ArrayList<>();
}
