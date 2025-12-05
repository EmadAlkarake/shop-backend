package com.emad.shop_backend;

import com.emad.shop_backend.model.Product;
import com.emad.shop_backend.repository.ProductRepository;
import com.emad.shop_backend.service.ProductService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    @Mock
    private ProductRepository repository;

    @InjectMocks
    private ProductService service;

    @Test
    void shouldSaveProduct_WhenPriceIsPositive() {
        Product p = new Product();
        p.setName("Test Product");
        p.setPrice(100.0);

        service.saveProduct(p);

        verify(repository, times(1)).save(p);
    }
    @Test
    void shouldThrowException_WhenPriceIsNegative() {
        Product p = new Product();
        p.setName("Bad Product");
        p.setPrice(-50.0);

        Exception exception = assertThrows(RuntimeException.class, () -> {
            service.saveProduct(p);
        });

        assertEquals("Price cannot be negative!", exception.getMessage());

        verify(repository, never()).save(any());
    }
}
