package com.example.cart_product.service.impl;

import com.example.cart_product.model.Product;
import com.example.cart_product.repository.IProductRepository;
import com.example.cart_product.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.Optional;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository iProductRepository;
    @Override
    public Page<Product> findAllAndSearch(String searchName, Pageable pageable) {
        return iProductRepository.findAllByNameContaining(searchName, pageable);
    }

    @Override
    public Optional<Product> findById(Integer id) {
        return iProductRepository.findById(id);
    }
}
