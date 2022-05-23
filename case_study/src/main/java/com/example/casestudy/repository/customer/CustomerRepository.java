package com.example.casestudy.repository.customer;

import com.example.casestudy.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
@Transactional
public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    Page<Customer> findAllByNameContaining(String name, Pageable pageable);
}
