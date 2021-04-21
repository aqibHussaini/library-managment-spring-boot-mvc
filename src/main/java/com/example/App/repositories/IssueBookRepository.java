package com.example.App.repositories;

import com.example.App.Entities.IssueBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IssueBookRepository extends JpaRepository<IssueBook,Integer> {
}
