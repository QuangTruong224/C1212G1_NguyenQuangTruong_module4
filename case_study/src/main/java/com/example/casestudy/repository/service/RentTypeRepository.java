package com.example.casestudy.repository.service;

import com.example.casestudy.model.service.RentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentTypeRepository extends JpaRepository<RentType,Integer> {
}
