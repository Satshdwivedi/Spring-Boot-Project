package com.example.demo.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class BorrowRecord {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private int id;
@ManyToOne 
@JoinColumn(name="br_mem_id")
@JsonBackReference 
private Member member;
@ManyToOne
@JoinColumn(name="br_book_id")
private Book book;
private LocalDate borrowdate;
private LocalDate returnDate;
public int getId() {
    return id;
}
public void setId(int id) {
    this.id = id;
}
public Member getMember() {
    return member;
}
public void setMember(Member member) {
    this.member = member;
}
public Book getBook() {
    return book;
}
public void setBook(Book book) {
    this.book = book;
}
public LocalDate getBorrowdate() {
    return borrowdate;
}
public void setBorrowdate(LocalDate borrowdate) {
    this.borrowdate = borrowdate;
}
public LocalDate getReturnDate() {
    return returnDate;
}
public void setReturnDate(LocalDate returnDate) {
    this.returnDate = returnDate;
}
public BorrowRecord(Member member, Book book, LocalDate borrowdate, LocalDate returnDate) {
    this.member = member;
    this.book = book;
    this.borrowdate = borrowdate;
    this.returnDate = returnDate;
}
public BorrowRecord() {
}

}
