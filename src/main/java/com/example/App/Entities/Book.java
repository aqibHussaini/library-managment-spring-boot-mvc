package com.example.App.Entities;

import javax.persistence.*;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @ManyToOne
    private  Category category;
    @Column(name = "name")
    private String book_name;
    @Column(name = "author")
    private String book_author;
    @Column(name = "pic")
    private String book_pic;
    @Column(name = "price")
    private Double book_price;

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", category=" + category +
                ", book_name='" + book_name + '\'' +
                ", book_author='" + book_author + '\'' +
                ", book_pic='" + book_pic + '\'' +
                ", book_price=" + book_price +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Book() {
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public String getBook_author() {
        return book_author;
    }

    public void setBook_author(String book_author) {
        this.book_author = book_author;
    }

    public String getBook_pic() {
        return book_pic;
    }

    public void setBook_pic(String book_pic) {
        this.book_pic = book_pic;
    }

    public Double getBook_price() {
        return book_price;
    }

    public void setBook_price(Double book_price) {
        this.book_price = book_price;
    }


    public Book(Category category, String book_name, String book_author, String book_pic, Double book_price) {
        this.category = category;
        this.book_name = book_name;
        this.book_author = book_author;
        this.book_pic = book_pic;
        this.book_price = book_price;
    }

    public Book(int id, Category category, String book_name, String book_author, String book_pic, Double book_price) {
        this.id = id;
        this.category = category;
        this.book_name = book_name;
        this.book_author = book_author;
        this.book_pic = book_pic;
        this.book_price = book_price;
    }
}
