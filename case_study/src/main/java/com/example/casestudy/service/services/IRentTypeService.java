package com.example.casestudy.service.services;

import com.example.casestudy.model.service.RentType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IRentTypeService {
    Page<RentType> findAll(Pageable pageable);

}
