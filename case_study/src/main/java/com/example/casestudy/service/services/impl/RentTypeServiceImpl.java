package com.example.casestudy.service.services.impl;

import com.example.casestudy.model.service.RentType;
import com.example.casestudy.repository.service.RentTypeRepository;
import com.example.casestudy.service.services.IRentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class RentTypeServiceImpl implements IRentTypeService {
    @Autowired
    private RentTypeRepository rentTypeRepository;
    @Override
    public Page<RentType> findAll(Pageable pageable) {
        return this.rentTypeRepository.findAll(pageable);
    }
}
