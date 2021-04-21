package com.example.App.Entities;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
public class IssueBook {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @ManyToOne
    private User user;

    @Override
    public String toString() {
        return "IssueBook{" +
                "id=" + id +
                ", user=" + user +
                ", book=" + book +
                ", issue_date=" + issue_date +
                ", return_date=" + return_date +
                ", status=" + status +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public LocalDate getIssue_date() {
        return issue_date;
    }

    public void setIssue_date(LocalDate issue_date) {
        this.issue_date = issue_date;
    }

    public LocalDate getReturn_date() {
        return return_date;
    }

    public void setReturn_date(LocalDate return_date) {
        this.return_date = return_date;
    }

    public short getStatus() {
        return status;
    }

    public void setStatus(short status) {
        this.status = status;
    }

    @ManyToOne
    private Book book;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate issue_date;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate return_date;
    private short status;

    public IssueBook() {
    }

    public IssueBook(int id, User user, Book book, LocalDate issue_date, LocalDate return_date, short status) {
        this.id = id;
        this.user = user;
        this.book = book;
        this.issue_date = issue_date;
        this.return_date = return_date;
        this.status = status;
    }
}
