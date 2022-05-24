package com.example.casestudy.service.services.impl;

import com.example.casestudy.model.service.ServiceType;
import com.example.casestudy.repository.service.ServiceTypeRepository;
import com.example.casestudy.service.services.IServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ServiceTypeServiceImpl implements IServiceTypeService {
    @Autowired
    private ServiceTypeRepository serviceTypeRepository;
    @Override
    public Page<ServiceType> findAll(Pageable pageable) {
        return this.serviceTypeRepository.findAll(pageable);
    }
}
