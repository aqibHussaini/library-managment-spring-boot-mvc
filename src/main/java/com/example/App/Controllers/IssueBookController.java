package com.example.App.Controllers;

import com.example.App.Entities.IssueBook;
import com.example.App.Entities.User;
import com.example.App.repositories.BookRepository;
import com.example.App.repositories.IssueBookRepository;
import com.example.App.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Controller
public class IssueBookController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    BookRepository bookRepository;
    @Autowired
    IssueBookRepository issueBookRepository;

    @PostMapping("/save_issue")
    @ResponseBody
    public String save_issue(@RequestParam int book_id, @RequestParam String return_date, Principal principal, IssueBook issueBook){
// 0 status means returned 1 means issue
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        issueBook.setBook(this.bookRepository.findById(book_id).get());
        issueBook.setUser(this.userRepository.findByUsername(principal.getName()));
        issueBook.setStatus((short) 1);
        issueBook.setIssue_date(LocalDate.now());
        issueBook.setReturn_date(LocalDate.parse(return_date));
//        return issueBook.toString();
        return   this.issueBookRepository.save(issueBook).toString();
//        return "issue_book.html";
    }
    @GetMapping("/view-issue-book")
    public String issueBook( Model model){
        model.addAttribute("issued_book",this.issueBookRepository.findAll());
        return "view_issued_book.html";
    }
}
