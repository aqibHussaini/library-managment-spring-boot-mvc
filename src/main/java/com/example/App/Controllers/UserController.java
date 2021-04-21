package com.example.App.Controllers;

import com.example.App.Entities.Book;
import com.example.App.Entities.User;
import com.example.App.repositories.BookRepository;
import com.example.App.repositories.UserRepository;
import com.example.App.repositories.categoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    categoryRepository categoryRepository;
    @Autowired
    BookRepository bookRepository;
    @GetMapping("/register")
    public String Form()
    {
        return "register.html";
    }
    @PostMapping("/save-user")
    public String Register(User user, Model model)
    {
        try
        {
            user.setRole("User");
            this.userRepository.save(user);
            model.addAttribute("msg","user registered");
        }
        catch (Exception e)
        {
         model.addAttribute("msg",e.getMessage());
        }
        return "register.html";
    }
    @GetMapping("/user-home")
    public String home(Model model)
    {
        model.addAttribute("categories",this.categoryRepository.findAll());
        return "userDashboard.html";
    }
    @GetMapping("/get-books/{c_id}")
    @ResponseBody
    public List<Book> getBooksById(@PathVariable int c_id)
    {
        List<Book> books;
        if(c_id==0)
        {
         books=   this.bookRepository.findAll();
        }
        else
        {
          books=  this.bookRepository.findByCategory(this.categoryRepository.findById(c_id).get());
        }
       return books;
    }
}
