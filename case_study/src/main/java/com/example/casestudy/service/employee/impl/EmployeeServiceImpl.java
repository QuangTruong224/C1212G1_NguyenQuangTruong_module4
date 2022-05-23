package com.example.casestudy.service.employee.impl;

import com.example.casestudy.model.employee.Employee;
import com.example.casestudy.repository.employee.EmployeeRepository;
import com.example.casestudy.service.employee.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class EmployeeServiceImpl implements IEmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public Page<Employee> findByName(String name, Pageable pageable) {
        return employeeRepository.findAllByNameContaining(name,pageable);
    }

    @Override
    public Page<Employee> findAll(Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }

    @Override
    public Employee findById(int id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Employee employee) {
employeeRepository.save(employee);
    }

    @Override
    public void remove(int id) {
employeeRepository.deleteById(id);
    }
}
