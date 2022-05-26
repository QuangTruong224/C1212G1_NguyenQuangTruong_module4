package com.codegym.repository.contract;

import com.codegym.model.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IContractRepository extends JpaRepository<Contract, Integer> {

    Page<Contract> findAll(Pageable pageable);
    Page<Contract> findAllByStatus(int s, Pageable pageable);
}
