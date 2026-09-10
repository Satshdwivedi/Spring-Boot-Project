package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Student;

public interface StudentRepository extends JpaRepository<Student,Integer> {
@Query("Select s from Student s Where s.age>20")
public List<Student>jpstud();
@Query("Select s from Student s Where s.age>:age")
public List<Student>jpstud1(@Param ("age") int age);
@Query("Select s from Student s where s.age>:age AND s.name=:name")
public List<Student>jpstud2(@Param("age")int age,@Param("name") String name);
@Query("Select s from Student s where s.name Like :name")
public List<Student>jpLike(@Param ("name")String name);
@Query("Select s from Student s Where s.age Between :minage AND :maxage")
public List<Student>jpBet(@Param ("minage")int minage,@Param("maxage")int maxage);
@Query("Select s from Student s where s.age In :ages")
public List<Student>jpIN(@Param("ages")List<Integer>ages);
@Query("Select Distinct s.age from Student s")
public List<Integer>getDistinctAge();
@Query("Select s  from Student s Order By s.age desc")
public List<Student>getOrderByAge();
@Query("Select s.age, Count(s) from Student s Group By s.age Having Count(s)>=2")
public List<Object[]>getHavingAge();
@Modifying 
@Query("UPDATE Student s Set s.age=:age where s.id=:id")
int updateAge(@Param("id")int id,@Param("age")int age);
@Modifying
@Query("DELETE from Student s where s.id=:id")
int deleteStudent(@Param("id")int id);
List<Student>findByName(String name);
List<Student>findByAge(int age);
List<Student>findByAgeGreaterThan(int age);
List<Student>findByNameContaining(String name);
List<Student>findByAgeBetween(int minage,int maxage);
List<Student>findByAgeIn(List<Integer>ages);



} 

