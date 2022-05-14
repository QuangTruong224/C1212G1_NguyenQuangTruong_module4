package com.codegym.service;


import com.codegym.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface IProductService {
    void save(Product product);
    Product findById(Integer id);
    void delete(Integer id);
    Page<Product> findByName(String name, Pageable pageable);

}
