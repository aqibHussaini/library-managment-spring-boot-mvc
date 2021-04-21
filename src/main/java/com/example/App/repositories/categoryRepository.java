package com.example.App.repositories;

import com.example.App.Entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface categoryRepository extends JpaRepository<Category,Integer> {

}
