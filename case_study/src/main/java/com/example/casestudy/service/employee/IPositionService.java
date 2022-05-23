package com.example.casestudy.service.employee;

import com.example.casestudy.model.customer.CustomerType;
import com.example.casestudy.model.employee.Position;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IPositionService {
    Page<Position> findAll(Pageable pageable);


}
