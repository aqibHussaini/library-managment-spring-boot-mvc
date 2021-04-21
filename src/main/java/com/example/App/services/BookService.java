package com.example.App.services;

import com.example.App.Entities.Book;
import com.example.App.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;
    public Book save(Book book)
    {
        this.bookRepository.save(book);
        return book;
    }
    public List<Book> getAll()
    {
        return this.bookRepository.findAll();
    }

}
