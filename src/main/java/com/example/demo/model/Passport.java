package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Passport {
 @Id
 private int id;
 private String passportno;
 public int getId() {
    return id;
 }
 public void setId(int id) {
    this.id = id;
 }
 
 public String getPassportno() {
    return passportno;
 }
 public void setPassportno(String passportno) {
    this.passportno = passportno;
 }
 public Passport() {
}
 public Passport(String passportno) {
    this.passportno = passportno;
 }

@OneToOne(mappedBy="passport")
private Member member;
 

}
