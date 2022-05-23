package com.example.casestudy.service.employee;

import com.example.casestudy.model.customer.CustomerType;
import com.example.casestudy.model.employee.Division;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IDivisionService {
    Page<Division> findAll(Pageable pageable);

}
