package com.example.casestudy.service.employee.impl;

import com.example.casestudy.model.employee.EducationDegree;
import com.example.casestudy.model.employee.Position;
import com.example.casestudy.repository.employee.EducationDegreeEmployeeRepository;
import com.example.casestudy.service.employee.IEducationDegreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class EducationDegreeServiceImpl implements IEducationDegreeService {
    @Autowired
    EducationDegreeEmployeeRepository educationDegreeEmployeeRepository;

    @Override
    public Page<EducationDegree> findAll(Pageable pageable) {
        return educationDegreeEmployeeRepository.findAll(pageable);
    }
}
