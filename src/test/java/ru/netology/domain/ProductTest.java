package ru.netology.domain;

import org.junit.jupiter.api.Test;
import ru.netology.manager.ProductManager;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {
    private Product product1 = new Product(1, "Product name", 300);

    @Test
    public void shouldMatchesNameIfExist(){
        String text = "Product name";
        assertTrue(product1.matches(text));
    }

    @Test
    public void shouldMatchesNameIfNotExist(){
        String text = "Not exist";
        assertFalse(product1.matches(text));
    }


}
