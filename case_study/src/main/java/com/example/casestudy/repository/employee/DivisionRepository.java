package com.example.casestudy.repository.employee;

import com.example.casestudy.model.employee.Division;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DivisionRepository extends JpaRepository<Division,Integer> {
}
