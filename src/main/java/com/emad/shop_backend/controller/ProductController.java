package com.emad.shop_backend.controller;

import com.emad.shop_backend.model.Product;
import com.emad.shop_backend.repository.ProductRepository;
import com.emad.shop_backend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping
    public List<Product> getAllProducts() {
        return service.getAllProducts();
    }

    @PostMapping
    public Product createProduct(@RequestBody Product newProduct) {
        return service.saveProduct(newProduct);
    }
}
