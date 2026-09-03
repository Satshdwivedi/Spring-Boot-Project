package com.example.demo.service;

import org.springframework.stereotype.Service;
import com.example.demo.model.Book;
import com.example.demo.model.BookDTO;

import java.util.ArrayList;
import java.util.Iterator;

@Service
public class BookService {
    ArrayList<Book> books = new ArrayList<>();

    public BookService() {
        books.add(new Book(101, "Java", "Smith", "Programming Language", 587));
        books.add(new Book(102, "Python", "Jhon", "Useful in AI", 489));
        books.add(new Book(103, "SQL", "David", "Useful in Database", 450));
    }

    public ArrayList<Book> getAllBooks() {
        return books;
    }

    public Book getBookById(int id) {
        for (Book b : books) {
            if (id == b.getId()) {
                return b;
            }
        }
        return null;
    }

    public ArrayList<Book> searchByTitle(String title) {
        ArrayList<Book> res = new ArrayList<>();
        for (Book p : books) {
            if (p.getTitle().equalsIgnoreCase(title)) {
                res.add(p);
            }
        }
        return res;
    }

    public Book addBook(Book bk) {
        books.add(bk);
        return bk;
    }

    public Book updateBook(int id, BookDTO dto) {
        for (Book s : books) {
            if (id == s.getId()) {
                s.setTitle(dto.getTitle());
                s.setAuthor(dto.getAuthor());
                s.setDiscription(dto.getDiscription());
                s.setPrice(dto.getPrice());
                return s;
            }
        }
        return null;
    }

    public boolean deleteBook(int id) {
        Iterator<Book> it = books.iterator();
        while (it.hasNext()) {
            Book s = it.next();
            if (id == s.getId()) {
                it.remove();
                return true;
            }
        }
        return false;
    }
}
