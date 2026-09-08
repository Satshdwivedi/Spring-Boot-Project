package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;

@Service
public class StudentService {
    private StudentRepository studentrepo;

    public StudentService(StudentRepository studentrepo) {
        this.studentrepo = studentrepo;
    }
    public Student addStudent(Student stu){
        return studentrepo.save(stu);
    }
    public List<Student>getAllStudents(){
        return studentrepo.findAll();
    }



}
