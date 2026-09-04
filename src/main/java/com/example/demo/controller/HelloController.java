package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.BookDTO;
import com.example.demo.model.Book;
import java.util.List;

import com.example.demo.model.ErrorResponse;
import com.example.demo.service.BookService;

import jakarta.validation.Valid;

@RestController
public class HelloController {
    private BookService bookservice;

    public HelloController(BookService bookservice) {
        this.bookservice = bookservice;
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
    public List<Book> books() {
        return bookservice.getAllBooks();
    }

    @GetMapping("/books/search")
    public List<Book> search(@RequestParam(required = false) String title) {
        return bookservice.searchByTitle(title);
    }

    @GetMapping("/book/{id}")
    public ResponseEntity<?> getBook(@PathVariable int id) {
        Book b = bookservice.getBookById(id);
        if (b == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(b);
    }

    @PostMapping("/books")
    public ResponseEntity<Book> addBook(@Valid @RequestBody BookDTO dto) {
        Book nb = new Book(dto.getId(), dto.getTitle(),
                dto.getAuthor(), dto.getDiscription(), dto.getPrice());
        Book sb = bookservice.addBook(nb);
        return ResponseEntity.status(201).body(sb);
    }

    @PutMapping("/books/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable int id,
            @Valid @RequestBody BookDTO dto) {
        Book updateBook = bookservice.updateBook(id, dto);
        if (updateBook == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updateBook);
    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable int id) {
        boolean deleted = bookservice.deleteBook(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.status(404).body(new ErrorResponse("Book not found"));

    }
}
