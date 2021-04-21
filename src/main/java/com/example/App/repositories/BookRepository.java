package com.example.App.repositories;

import com.example.App.Entities.Book;
import com.example.App.Entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book,Integer> {
    List<Book> findByCategory(Category category);
}
