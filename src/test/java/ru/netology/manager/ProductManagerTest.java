package ru.netology.manager;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    private ProductRepository productRepository = new ProductRepository();

    private Product first = new Product(1, "first", 100);
    private Product second = new Product(2, "second", 200);
    private Product third = new Product(3, "third", 300);

    @BeforeEach
    public void setUp() {
        productRepository.save(first);
        productRepository.save(second);
        productRepository.save(third);
    }

    @Test
    void add() {
        Product[] actual = productRepository.findAll();
        Product[] expected = new Product[]{first, second, third};

        assertArrayEquals(expected, actual);
    }

    @Test
    void searchBy() {
    }

    @Test
    void matchesBookSearchInName(Book book, "firstName") {
//        Product product = new Book(1,"firstName", 100, "firstAuthor");
//        productRepository.save(product);
//
////        Book actual = book.getName();
//        String actual = "firstName";
//        String expected = "firstName";
//
//        assertEquals(expected, actual);
//    }
}