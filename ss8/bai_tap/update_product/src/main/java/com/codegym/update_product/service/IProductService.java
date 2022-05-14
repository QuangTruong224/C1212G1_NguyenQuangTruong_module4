package com.codegym.update_product.service;

import com.codegym.update_product.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProductService {
    void save(Product product);
    Product findById(Integer id);
    void delete(Integer id);
    Page<Product> findByName(String name, Pageable pageable);

}
