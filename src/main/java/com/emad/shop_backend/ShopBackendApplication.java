package com.emad.shop_backend;

import com.emad.shop_backend.model.Category;
import com.emad.shop_backend.model.Product;
import com.emad.shop_backend.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class ShopBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopBackendApplication.class, args);
	}

    @Bean
    public CommandLineRunner demo(ProductRepository productRepository) {
        return args -> {
          Product product = new Product();
          product.setName("iPhone 15");
          product.setPrice(1500.00);
          product.setCategory(Category.ELECTRONICS);

            productRepository.save(product);
            System.out.println("🎉 Product saved with ID: " + product.getId());

            List<Product> list = productRepository.findAll();
            System.out.println("--- All Products ---");
            list.forEach(System.out::println);
        };
    }

}
