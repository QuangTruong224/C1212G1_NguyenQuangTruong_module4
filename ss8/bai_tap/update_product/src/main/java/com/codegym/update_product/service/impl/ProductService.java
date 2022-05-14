package com.codegym.update_product.service.impl;

import com.codegym.update_product.model.Product;
import com.codegym.update_product.repository.ProductRepository;
import com.codegym.update_product.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    private ProductRepository productRepository;



    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public Product findById(Integer id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) {
productRepository.deleteById(id);
    }


    @Override
    public Page<Product> findByName(String name, Pageable pageable) {
        return productRepository.findByTitle(name, pageable);
    }

}
