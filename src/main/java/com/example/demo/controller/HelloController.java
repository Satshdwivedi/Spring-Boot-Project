package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.BookDTO;
import com.example.demo.model.Book;
import java.util.ArrayList;
import java.util.Iterator;
import com.example.demo.model.ErrorResponse;

import jakarta.validation.Valid;

@RestController
public class HelloController {
    ArrayList<Book> books = new ArrayList<>();

    public HelloController() {
        books.add(new Book(101, "Java", "Smith"));
        books.add(new Book(102, "Python", "Jhon"));
        books.add(new Book(103, "SQL", "David"));
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }

    @GetMapping("/book")
    public Book book() {
        return new Book(101, "Java", "Smith");
    }

    @GetMapping("/books")
    public ArrayList<Book> books() {

        return books;
    }

    @GetMapping("/books/search")
    public ArrayList<Book> search(@RequestParam(required = false) String title) {
        ArrayList<Book> res = new ArrayList<>();
        for (Book p : books) {
            if (p.getTitle().equalsIgnoreCase(title))
                res.add(p);
        }
        return res;
    }

    @GetMapping("/book/{id}")
    public ResponseEntity<?> getBook(@PathVariable int id) {

        for (Book s : books) {
            if (id == s.getId()) {
                return ResponseEntity.ok(s);
            }
        }
        return ResponseEntity.notFound().build();

    }

    @PostMapping("/books")
    public ResponseEntity<Book> addBook(@Valid @RequestBody BookDTO dto) {
        Book nb=new Book(dto.getId(),dto.getTitle(),dto.getAuthor());
        books.add(nb);
        return ResponseEntity.status(201).body(nb);
    }

    @PutMapping("/books/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable int id,
            @RequestBody Book book) {

        for (Book s : books) {
            if (id == s.getId()) {
                s.setTitle(book.getTitle());
                s.setAuthor(book.getAuthor());
                return ResponseEntity.ok(s);
            }
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable int id) {
        boolean found = false;
        Iterator<Book> it = books.iterator();
        while (it.hasNext()) {
            Book s = it.next();
            if (id == s.getId()) {
                it.remove();
                found = true;
                break;
            }
        }
        if (found)
            return ResponseEntity.noContent().build();
        return ResponseEntity.status(404).body(new ErrorResponse("Book not found"));

    }
}
