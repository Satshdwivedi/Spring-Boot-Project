package com.example.demo.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Entity
@Getter 
@Setter
@NoArgsConstructor 
public class Course {
    
    @Id
    private int id;
    private String courses;
   
    @ManyToMany(mappedBy="cou")
    @JsonBackReference
    private List<Student>stud;
    public List<Student> getStud() {
        return stud;
    }
    public void setStud(List<Student> stud) {
        this.stud = stud;
    }
}
