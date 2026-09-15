package com.example.demo.model;

import java.time.LocalDate;

//import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Setter
@NoArgsConstructor 
public class BorrowRecord {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private int id;
@ManyToOne 
@JoinColumn(name="br_mem_id")
@JsonIgnore 
private Member member;
@ManyToOne
@JoinColumn(name="br_book_id")
private Book book;
private LocalDate borrowdate;
private LocalDate returnDate;

public BorrowRecord(Member member, Book book, LocalDate borrowdate, LocalDate returnDate) {
    this.member = member;
    this.book = book;
    this.borrowdate = borrowdate;
    this.returnDate = returnDate;
}

}
