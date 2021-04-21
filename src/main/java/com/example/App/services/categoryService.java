package com.example.App.services;

import com.example.App.Entities.Category;
import com.example.App.repositories.categoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class categoryService {
    @Autowired
    categoryRepository categoryRepository;
    public Category saveCategory(Category category)
    {
        Category category_obj=null;
        try
        {
       category_obj=this.categoryRepository.save(category);
        }
        catch (Exception e)
        {

        }
        return category_obj;
    }
   public List<Category> getAllCategory()
    {
        return this.categoryRepository.findAll();
    }
   public Category getCategoryById(int id)
    {
        return this.categoryRepository.findById(id).get();
    }
    public void update_category(Category category)
    {
        this.categoryRepository.save(category);
    }
    public void delete_category(int id)
    {
        this.categoryRepository.delete(this.categoryRepository.findById(id).get());
    }
}
