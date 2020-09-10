package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    private ProductRepository repository = new ProductRepository();
    private ProductManager manager = new ProductManager(repository);
    private Book book1 = new Book(1, "Book name", 100, "Author1");
    private Book book2 = new Book(2, "Book name", 200, "Author2");
    private Book book3 = new Book(3, "Third book", 300, "Author2");
    private Smartphone smartphone1 = new Smartphone(1, "Smartphone name", 300, "Manufacturer1");
    private Smartphone smartphone2 = new Smartphone(2, "Smartphone name", 500, "Manufacturer2");
    private Smartphone smartphone3 = new Smartphone(3, "Smartphone3", 700, "Manufacturer2");

    @BeforeEach
    public void setUp() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);
    }

    @Test
    void searchBookByNameIfExistOneProduct() {
        String text = "Third book";

        Product[] expected = new Product[]{book3};
        Product[] actual = manager.searchBy(text);
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchBookByNameIfExistTwoProduct() {
        String text = "Book name";

        Product[] expected = new Product[]{book1, book2};
        Product[] actual = manager.searchBy(text);
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchBookByNameIfNotExist() {
        String text = "Not exist";

        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy(text);
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchBookByAuthorIfExistOneProduct() {
        String text = "Author1";

        Product[] expected = new Product[]{book1};
        Product[] actual = manager.searchBy(text);
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchBookByAuthorIfExistTwoProduct() {
        String text = "Author2";

        Product[] expected = new Product[]{book2, book3};
        Product[] actual = manager.searchBy(text);
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchBookByAuthorIfNotExist() {
        String text = "Not exist author";

        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy(text);
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchSmartphoneByNameIfExistOneProduct() {
        String text = "Smartphone3";

        Product[] expected = new Product[]{smartphone3};
        Product[] actual = manager.searchBy(text);
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchSmartphoneByNameIfExistTwoProduct() {
        String text = "Smartphone name";

        Product[] expected = new Product[]{smartphone1, smartphone2};
        Product[] actual = manager.searchBy(text);
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchSmartphoneByNameIfNotExist() {
        String text = "Not exist name";

        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy(text);
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchSmartphoneByManufacturerIfExistOneProduct() {
        String text = "Manufacturer1";

        Product[] expected = new Product[]{smartphone1};
        Product[] actual = manager.searchBy(text);
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchSmartphoneByManufacturerIfExistTwoProduct() {
        String text = "Manufacturer2";

        Product[] expected = new Product[]{smartphone2, smartphone3};
        Product[] actual = manager.searchBy(text);
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchSmartphoneByManufacturerIfNotExist() {
        String text = "Not exist Manufacturer";

        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy(text);
        assertArrayEquals(expected, actual);
    }
}