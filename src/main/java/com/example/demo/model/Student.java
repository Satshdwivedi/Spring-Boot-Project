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
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter 
@Setter 
@NoArgsConstructor
@AllArgsConstructor 
@Builder
  
@Table(name="student")
public class Student {
@Id
private int id;
private String name;
private int age;

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
