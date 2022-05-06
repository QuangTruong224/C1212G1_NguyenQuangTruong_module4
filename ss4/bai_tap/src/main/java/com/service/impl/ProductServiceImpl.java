package com.service.impl;

import com.model.Product;
import com.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class ProductServiceImpl implements ProductService {
    private static Map<Integer, Product> products = new HashMap<>();

    static {
        products.put(1, new Product(1, "Bia huda", "10000", "Còn hàng", "Huế"));
        products.put(2, new Product(2, "Bia Larue", "11000", "Còn hàng", "Đà Nẵng"));
        products.put(3, new Product(3, "Bia dung quất", "8000", "Còn hàng", "Quảng Ngãi"));
        products.put(4, new Product(4, "Bia 333", "15000", "Còn hàng", "Sài gòn"));
        products.put(5, new Product(5, "Bia heneiken", "25000", "Còn hàng", "Toàn quốc"));
        products.put(6, new Product(6, "Bia tiger", "18000", "Còn hàng", "Toàn quốc"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void update(int id, Product product) {
        products.put(id, product);
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }

    @Override
    public Product searchById(int id) {
        return products.get(id);
    }

    @Override
    public List<Product> searchByName(String name) {
        List<Product> productMap = new ArrayList<>();
        for (Map.Entry<Integer, Product> product : products.entrySet()) {
            if (product.getValue().getNameProduct().contains(name)) {
                productMap.add(product.getValue());
            }
        }
        return productMap;
    }
}
