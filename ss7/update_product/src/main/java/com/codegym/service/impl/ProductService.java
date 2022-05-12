package com.codegym.service.impl;


import com.codegym.model.Product;
import com.codegym.repository.IProductRepository;
import com.codegym.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository iProductRepository;


    @Override
    public void save(Product product) {
        this.iProductRepository.save(product);
    }

    @Override
    public Product findById(Integer id) {
        return this.iProductRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) {
        this.iProductRepository.deleteById(id);
    }

    @Override
    public Page<Product> findByName(String name, Pageable pageable) {
        return iProductRepository.findByTitle("%"+name+"%", pageable);
    }
}
