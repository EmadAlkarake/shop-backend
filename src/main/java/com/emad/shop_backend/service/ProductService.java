package com.emad.shop_backend.service;

import com.emad.shop_backend.model.Product;
import com.emad.shop_backend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    public Product saveProduct(Product product) {
        if (product.getPrice() < 0) {
            throw new RuntimeException("Price cannot be negative!");
        }
        return repository.save(product);
    }


}
