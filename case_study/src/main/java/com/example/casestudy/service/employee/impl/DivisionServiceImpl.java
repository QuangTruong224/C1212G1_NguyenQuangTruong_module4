package com.example.casestudy.service.employee.impl;

import com.example.casestudy.model.employee.Division;
import com.example.casestudy.repository.employee.DivisionRepository;
import com.example.casestudy.service.employee.IDivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class DivisionServiceImpl implements IDivisionService {
    @Autowired
    DivisionRepository divisionRepository;

    @Override
    public Page<Division> findAll(Pageable pageable) {
        return divisionRepository.findAll(pageable);
    }

}
