package com.example.casestudy.service.customer;

import com.example.casestudy.model.customer.CustomerType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ICustomerTypeService {
    Page<CustomerType> findAll(Pageable pageable);

    CustomerType findById(int id);

    void save(CustomerType customerType);

    void remove(int id);
}
