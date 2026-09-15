package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.example.demo.repository.CourseRepository;

import lombok.RequiredArgsConstructor;

import com.example.demo.model.Course;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courserepo;
    
    public Course addCourses(Course co){
        return courserepo.save(co);
    }
    public List<Course>getAllCoruses(){
        return courserepo.findAll();
    }
    public Course getCouById(int id){
        return courserepo.findById(id).orElse(null);
    }
}
