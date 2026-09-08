package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.example.demo.repository.CourseRepository;
import com.example.demo.model.Course;

@Service
public class CourseService {

    private CourseRepository courserepo;

    public CourseService(CourseRepository courserepo) {
        this.courserepo = courserepo;
    }
    
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
