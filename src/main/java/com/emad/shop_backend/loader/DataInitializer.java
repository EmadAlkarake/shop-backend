package com.emad.shop_backend.loader;

import com.emad.shop_backend.model.AppUser;
import com.emad.shop_backend.model.Category;
import com.emad.shop_backend.model.Product;
import com.emad.shop_backend.repository.ProductRepository;
import com.emad.shop_backend.repository.UserRepository;
import com.emad.shop_backend.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private ProductRepository productRepo;

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public void run(String... args) throws Exception {
        if (productRepo.count() == 0) {
            Product p1 = new Product();
            p1.setName("iPhone 15");
            p1.setPrice(4000.0);
            p1.setCategory(Category.ELECTRONICS);
            productRepo.save(p1);
            System.out.println("🎉 Initial products loaded.");
        }
        if (userRepo.findByUsername("admin").isEmpty()) {
            AppUser admin = new AppUser();
            admin.setUsername("admin");
            admin.setPassword(encoder.encode("admin123"));
            admin.setRole("ROLE_ADMIN");
            userRepo.save(admin);
            System.out.println("👤 Admin user created: admin / admin123");

        }
        String token = jwtUtil.generateToken("admin");
        System.out.println("🎟️ Generated Token for testing: " + token);
    }

}
