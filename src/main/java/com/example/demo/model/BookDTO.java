package com.example.demo.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public class BookDTO {
@Positive
private int id;
@NotBlank
private String title;
@NotBlank
private String author;
public String getDiscription() {
    return discription;
}
public void setDiscription(String discription) {
    this.discription = discription;
}
public double getPrice() {
    return price;
}
public void setPrice(double price) {
    this.price = price;
}
@NotBlank
private String discription;
@Positive
private double price;
public int getId() {
    return id;
}
public void setId(int id) {
    this.id = id;
}
public String getTitle() {
    return title;
}
public void setTitle(String title) {
    this.title = title;
}
public String getAuthor() {
    return author;
}
public void setAuthor(String author) {
    this.author = author;
}
}
