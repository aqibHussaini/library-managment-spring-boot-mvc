package com.example.App.Controllers;

import com.example.App.Entities.Category;
import com.example.App.services.categoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Controller
public class categoriesController {
    @Autowired
    categoryService categoryService;

    @GetMapping("/edit/{id}")
    public String Edit(Model model,@PathVariable int id) {
        model.addAttribute("category",this.categoryService.getCategoryById(id));
        return "update-categories";
    }
    @PostMapping("/update-category")
    public String Update(Model model,Category category) {
        Date date=new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        category.setTime(simpleDateFormat.format(date));
        this.categoryService.update_category(category);
        return "redirect:/Categories";
    }
    @GetMapping("/Categories")
    public String Home(Model model) {
        model.addAttribute("msg",null);
       model.addAttribute( "categories",this.categoryService.getAllCategory());
        return "categories";
    }
    @GetMapping("/delete/{id}")
    public String Home(Model model, @PathVariable int id) {
        this.categoryService.delete_category(id);
        return "redirect:/Categories";
    }
    @PostMapping("/save-category")
    public String saveCategory(Model model, Category category) {
        model.addAttribute("msg",null);
        try
        {
            Date date=new Date();
            SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
            category.setTime(simpleDateFormat.format(date));
            this.categoryService.saveCategory(category);
            model.addAttribute("msg","Data has been saved succesfully!!");
            model.addAttribute( "categories",this.categoryService.getAllCategory());
        }
        catch (Exception e)
        {
            model.addAttribute("msg","Oooppss!! "+e.getMessage());
        }
        return "categories";
    }

}
