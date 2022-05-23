package com.example.casestudy.service.customer.impl;

import com.example.casestudy.model.customer.CustomerType;
import com.example.casestudy.repository.customer.CustomerTypeRepository;
import com.example.casestudy.service.customer.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CustomerTypeServiceImpl implements ICustomerTypeService {
    @Autowired
    CustomerTypeRepository customerTypeRepository;

    @Override
    public Page<CustomerType> findAll(Pageable pageable) {
        return customerTypeRepository.findAll(pageable);
    }

    @Override
    public CustomerType findById(int id) {
        return customerTypeRepository.findById(id).orElse(null);
    }


    @Override
    public void save(CustomerType customerType) {
        customerTypeRepository.save(customerType);
    }

    @Override
    public void remove(int id) {
        customerTypeRepository.deleteById(id);
    }
}
