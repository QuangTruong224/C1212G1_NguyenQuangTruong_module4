package com.example.casestudy.service.customer;

import com.example.casestudy.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ICustomerService {
    Page<Customer> findByName(String name, Pageable pageable);
    Page<Customer> findAll(Pageable pageable);

    Customer findById(int id);

    void save(Customer customer);

    void remove(int id);
}
