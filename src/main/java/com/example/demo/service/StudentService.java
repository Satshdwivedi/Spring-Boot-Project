package com.example.demo.service;

import java.util.List;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public Page<Student> getStudents(Pageable pageable){
        return studentrepo.findAll(pageable);
    } 
    public List<Student> getJPStudents(){
        return studentrepo.jpstud();
    }

    public List<Student> getJPStuden(int age){
        return studentrepo.jpstud1(age);
    }
    public List<Student>getJPS(int age,String name){
        return studentrepo.jpstud2(age,name);
    }
    public List<Student>getJPS1(String name){
        return studentrepo.jpLike(name);
    }
    public List<Student>getJPS2(int minage,int maxage){
        return studentrepo.jpBet(minage, maxage);
    }
    public List<Student>getJPS3(List<Integer>ages){
        return studentrepo.jpIN(ages);
    }
    public List<Integer>getJPS4(){
        return studentrepo.getDistinctAge();
    }
    public List<Student>getJPS5(){
        return studentrepo.getOrderByAge();
    }
    public List<Object[]>getJPS6(){
        return studentrepo.getHavingAge();
    }
    @Transactional 
    public int getJPS7(int id,int age){
        return studentrepo.updateAge(id,age);
    }
    @Transactional 
    public int getJPS8(int id){
        return studentrepo.deleteStudent(id);
    }
}
