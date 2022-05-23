package com.example.casestudy.service.employee;

import com.example.casestudy.model.employee.EducationDegree;
import com.example.casestudy.model.employee.Position;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IEducationDegreeService {
    Page<EducationDegree> findAll(Pageable pageable);

}
