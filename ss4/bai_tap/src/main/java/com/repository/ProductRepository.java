package com.repository;

import com.model.Product;

import java.util.List;

public interface ProductRepository {
    List<Product> findAll();

    void  save(Product product);

    Product findById(int id);

    void update( Product product);

    void remove(Product product);


    Product searchById(int id);

    List<Product> searchByName(String name);
}
