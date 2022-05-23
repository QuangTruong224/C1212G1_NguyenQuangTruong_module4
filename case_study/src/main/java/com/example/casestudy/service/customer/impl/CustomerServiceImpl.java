package com.example.casestudy.service.customer.impl;

import com.example.casestudy.model.customer.Customer;
import com.example.casestudy.repository.customer.CustomerRepository;
import com.example.casestudy.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerServiceImpl implements ICustomerService {
    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Page<Customer> findByName(String name, Pageable pageable) {
        return customerRepository.findAllByNameContaining(name, pageable);
    }

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

    @Override
    public Customer findById(int id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void remove(int id) {
        customerRepository.deleteById(id);
    }
}
