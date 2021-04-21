package com.example.App.Controllers;

import com.example.App.Entities.Book;
import com.example.App.Entities.Category;
import com.example.App.services.BookService;
import com.example.App.services.categoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

@Controller
public class BookController {
    @Autowired
    private BookService bookService;
    @Autowired
    private categoryService categoryService;

    @PostMapping("/save-book")
    public String saveBook(Model model,  Book book, @RequestParam("picture")MultipartFile multipartFile, @RequestParam("book_category") int category_id ) {
        try
        {
            File file =new File("C:\\Users\\Bhatti\\Desktop\\final_projects\\libraryManagementSystem\\src\\main\\resources\\static\\images\\"+multipartFile.getOriginalFilename());
            multipartFile.transferTo(file);
            book.setBook_pic(multipartFile.getOriginalFilename());
           book.setCategory(this.categoryService.getCategoryById(category_id));
            Book save_book=this.bookService.save(book);
            model.addAttribute("result",save_book.getBook_name()+" has been saved!!");
        }
        catch (Exception e)
        {
            model.addAttribute("result",e.getMessage());
        }
        return "Books.html";
    }
    @GetMapping("/add-book")
    public String bookForm(Model model)
    {
        List<Category> categories=this.categoryService.getAllCategory();
        List<Book> books=this.bookService.getAll();
        model.addAttribute("result",null);
        model.addAttribute("categories",categories);
        model.addAttribute("books",books);
        return "Books.html";
    }
    @GetMapping("/view-book")
    public String viewBooks(Model model)
    {
        model.addAttribute("categories",this.categoryService.getAllCategory());
        List<Book> books=this.bookService.getAll();
        model.addAttribute("result",null);
        model.addAttribute("books",books);
        return "Books.html";
    }
}
