package com.example.demo.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter 
@Setter 
@NoArgsConstructor 
public class BookDTO {

@NotBlank
private String title;
@NotBlank
private String author;

@NotBlank
private String discription;
@Positive
private double price;

}
