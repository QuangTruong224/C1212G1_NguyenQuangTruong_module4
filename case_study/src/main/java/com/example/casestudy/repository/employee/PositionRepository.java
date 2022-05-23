package com.example.casestudy.repository.employee;

import com.example.casestudy.model.employee.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PositionRepository extends JpaRepository<Position,Integer> {
}
