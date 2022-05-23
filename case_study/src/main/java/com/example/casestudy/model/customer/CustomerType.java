package com.example.casestudy.model.customer;


import javax.persistence.*;
import java.util.Set;

@Entity
public class CustomerType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String typeName;


    @OneToMany(mappedBy = "customerType",cascade = CascadeType.ALL)
    private Set<Customer> customers;

    public CustomerType() {
    }

    public CustomerType(int id, String typeName) {
        this.id = id;
        this.typeName = typeName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
