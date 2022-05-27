package com.codegym.model.customer;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "customer_type")
public class CustomerType {
    @Id
    private int id;
    private String name;


    @OneToMany (mappedBy = "customerType",cascade = CascadeType.ALL)
    private List<Customer> customerList;

    public CustomerType() {
    }

    public CustomerType(int id, String name, List<Customer> customerList) {
        this.id = id;
        this.name = name;
        this.customerList = customerList;
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

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }
}
