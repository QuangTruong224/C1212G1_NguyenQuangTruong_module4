package com.codegym.update_product.repository;

import com.codegym.update_product.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
    @Query("select s from Product s where s.name like :name")
    Page<Product> findByTitle(@Param("name")String name, Pageable pageable);
}
