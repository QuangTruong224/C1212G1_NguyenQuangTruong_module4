package com.example.casestudy.repository.employee;

import com.example.casestudy.model.employee.EducationDegree;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducationDegreeEmployeeRepository extends JpaRepository<EducationDegree,Integer> {
}
