package com.example.demo.service;


import org.springframework.stereotype.Service;
import com.example.demo.model.Book;
import com.example.demo.model.BookDTO;
import com.example.demo.repository.BookRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j 
public class BookService {
    private  final BookRepository bookrepo;
    
    public List<Book> getAllBooks() {
        log.info("Fetching All Books");
        return bookrepo.findAll();
    }

    public Book getBookById(int id) {
        Book book= bookrepo.findById(id).orElse(null);
        if(book==null){
            log.warn("Book not found with id{}",id);
        }
        return book;
    }

    public List<Book> searchByTitle(String title) {
        log.debug("searching book with title:{}",title);
        return bookrepo.findByTitleIgnoreCase(title);
    }

    public Book addBook(Book bk) {
        return bookrepo.save(bk);
    }

    public Book updateBook(int id, BookDTO dto) {

        Book s = bookrepo.findById(id).orElse(null);
        if (s == null)
            return null;
        s.setTitle(dto.getTitle());
        s.setAuthor(dto.getAuthor());
        s.setDiscription(dto.getDiscription());
        s.setPrice(dto.getPrice());
        return bookrepo.save(s);
    }

    public boolean deleteBook(int id) {
        if (bookrepo.existsById(id)) {
            bookrepo.deleteById(id);
            return true;
        }

        return false;
    }
}
