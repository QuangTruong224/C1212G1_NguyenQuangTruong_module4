package com.example.casestudy.repository.employee;

import com.example.casestudy.model.customer.Customer;
import com.example.casestudy.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    Page<Employee> findAllByNameContaining(String name, Pageable pageable);

}
