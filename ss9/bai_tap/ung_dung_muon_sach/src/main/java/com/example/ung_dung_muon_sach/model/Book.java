package com.example.ung_dung_muon_sach.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;
    private int quantity;
    private String author;

    @OneToMany(mappedBy = "book")
    Set<Borrow> borrowSet;


    public Book(int id, String name, int quantity, String author, Set<Borrow> borrowSet) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.author = author;
        this.borrowSet = borrowSet;
    }

    public Book() {
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Set<Borrow> getBorrowSet() {
        return borrowSet;
    }

    public void setBorrowSet(Set<Borrow> borrowSet) {
        this.borrowSet = borrowSet;
    }
}
