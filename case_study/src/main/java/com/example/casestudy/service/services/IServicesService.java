package com.example.casestudy.service.services;

import com.example.casestudy.model.service.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IServicesService {
    Page<Service> findByName(String name, Pageable pageable);
    Page<Service> findAll(Pageable pageable);

    Service findById(Integer id);

    void save(Service service);

    void remove(Integer id);
}
