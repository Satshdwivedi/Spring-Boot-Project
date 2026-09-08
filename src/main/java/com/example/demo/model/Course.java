package com.example.demo.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Course {
    
    @Id
    private int id;
    private String courses;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getCourses() {
        return courses;
    }
    public void setCourses(String courses) {
        this.courses = courses;
    }
    public Course() {
    }
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
