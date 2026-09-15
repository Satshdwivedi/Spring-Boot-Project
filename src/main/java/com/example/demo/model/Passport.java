package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Setter
@NoArgsConstructor 
public class Passport {
 @Id
 private int id;
 private String passportno;
 
 public Passport(String passportno) {
    this.passportno = passportno;
 }

@OneToOne(mappedBy="passport")
private Member member;
 

}
