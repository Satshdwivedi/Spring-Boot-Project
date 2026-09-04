package com.example.demo.service;

import org.springframework.stereotype.Service;
import com.example.demo.model.Book;
import com.example.demo.model.BookDTO;
import com.example.demo.repository.BookRepository;

import java.util.List;

@Service
public class BookService {
    private BookRepository bookrepo;

    public BookService(BookRepository bookrepo) {
        this.bookrepo = bookrepo;
    }

    public List<Book> getAllBooks() {
        return bookrepo.findAll();
    }

    public Book getBookById(int id) {
        return bookrepo.findById(id).orElse(null);
    }

    public List<Book> searchByTitle(String title) {
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
