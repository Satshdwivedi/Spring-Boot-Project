package com.example.demo.repository;

import com.example.demo.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface BookRepository extends JpaRepository<Book,Integer> //Book yahan entity class ka nam 
 {  List<Book>findByTitleIgnoreCase(String title);                                                                  //aur Integer primary key ka data type hai





}
