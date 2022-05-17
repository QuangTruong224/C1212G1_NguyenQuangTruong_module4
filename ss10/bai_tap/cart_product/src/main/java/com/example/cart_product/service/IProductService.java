package com.example.cart_product.service;

import com.example.cart_product.model.Product;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;
import java.util.Optional;

public interface IProductService {
    Page<Product> findAllAndSearch(String searchName, Pageable pageable);

    Optional<Product> findById(Integer id);
}
