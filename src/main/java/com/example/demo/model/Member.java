package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

@Entity
@Getter 
@Setter 
@NoArgsConstructor
@AllArgsConstructor  
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String email;
    private String mobno;
    private String password;
    private String role;
    
    @OneToMany(mappedBy="member")
    @JsonIgnore 
    private List<BorrowRecord>borrowRecord=new ArrayList<>();
    
    @JsonIgnore
    public List<BorrowRecord>getBorrowRecords(){
        return borrowRecord;
     }

    @OneToOne
    @JoinColumn(name="passport_id")
    private Passport passport;

    public Member(Passport passport) {
        this.passport = passport;
    }
}
