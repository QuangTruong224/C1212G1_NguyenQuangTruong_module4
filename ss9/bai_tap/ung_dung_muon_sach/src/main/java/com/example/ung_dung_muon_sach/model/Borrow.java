package com.example.ung_dung_muon_sach.model;

import javax.persistence.*;

@Entity
@Table(name = "borrow")
public class Borrow {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(unique = true)
    private int ssBook;

    @ManyToOne
    @JoinColumn(name = "book_id",referencedColumnName = "id")
    private Book book;

    public Borrow(String s, Book book) {
    }

    public Borrow(int id, int ssBook, Book book) {
        this.id = id;
        this.ssBook = ssBook;
        this.book = book;
    }

    public Borrow(int ssBook, Book book) {
        this.ssBook = ssBook;
        this.book = book;
    }

    public Borrow() {

    }

    public Borrow(int code, int id) {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSsBook() {
        return ssBook;
    }

    public void setSsBook(int ssBook) {
        this.ssBook = ssBook;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
