package com.example.demo.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="student")
public class Student {
@Id
private int id;
private String name;
private int age;
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
public int getAge() {
    return age;
}
public void setAge(int age) {
    this.age = age;
}
public Student() {
}
@ManyToMany 
@JoinTable(name="student_course",joinColumns=@JoinColumn(name="student_id"),
           inverseJoinColumns=@JoinColumn(name="course_id") )
@JsonIgnore 
 private List<Course>cou;
public List<Course> getCou() {
    return cou;
}
public void setCou(List<Course> cou) {
    this.cou = cou;
}                      

}
