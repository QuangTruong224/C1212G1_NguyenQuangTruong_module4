package com.example.casestudy.service.services.impl;

import com.example.casestudy.model.service.Service;
import com.example.casestudy.repository.service.ServiceRepository;
import com.example.casestudy.service.services.IServicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


@org.springframework.stereotype.Service
public class ServicesServiceImpl implements IServicesService {
    @Autowired
    private ServiceRepository serviceRepository;


    @Override
    public Page<Service> findByName(String name, Pageable pageable) {
        return this.serviceRepository.findAllByNameServiceContaining(name, pageable);
    }

    @Override
    public Page<Service> findAll(Pageable pageable) {
        return this.serviceRepository.findAll(pageable);
    }

    @Override
    public Service findById(Integer id) {
        return this.serviceRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Service service) {
        this.serviceRepository.save(service);
    }


    @Override
    public void remove(Integer id) {
        this.serviceRepository.deleteById(id);
    }
}
