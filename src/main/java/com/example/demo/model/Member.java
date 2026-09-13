package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String email;
    private String mobno;
    private String password;
    private String role;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobno() {
        return mobno;
    }

    public void setMobno(String mobno) {
        this.mobno = mobno;
    }
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Member(String name, String email, String mobno, String password, String role) {
        this.name = name;
        this.email = email;
        this.mobno = mobno;
        this.password = password;
        this.role = role;
    }
    public Member() {
    }
   
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

    public Passport getPassport() {
        return passport;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
    }



}
