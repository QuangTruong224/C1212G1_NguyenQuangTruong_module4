package com.example.casestudy.service.employee;


import com.example.casestudy.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IEmployeeService {
    Page<Employee> findByName(String name, Pageable pageable);
    Page<Employee> findAll(Pageable pageable);

    Employee findById(int id);

    void save(Employee employee);

    void remove(int id);
}
