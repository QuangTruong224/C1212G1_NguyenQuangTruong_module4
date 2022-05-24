package com.example.casestudy.service.services;


import com.example.casestudy.model.service.ServiceType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IServiceTypeService {
    Page<ServiceType> findAll(Pageable pageable);

}
