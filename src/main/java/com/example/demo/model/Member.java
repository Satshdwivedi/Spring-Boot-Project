package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String email;
    private String mobno;
    
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

    public Member(String name, String email, String mobno) {
        this.name = name;
        this.email = email;
        this.mobno = mobno;
    }
    

    public Member() {
    }


    @OneToMany(mappedBy="member")
    @JsonManagedReference
    private List<BorrowRecord>borrowRecord=new ArrayList<>();
    public List<BorrowRecord>getBorrowRecords(){
        return borrowRecord;
    }


}
