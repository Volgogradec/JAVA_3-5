package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BookTest {
    private Book book = new Book(1, "Book name", 100, "Author1");

    @Test
    public void shouldMatchesNameIfExist() {
        String text = "Book name";
        assertTrue(book.matches(text));
    }

    @Test
    public void shouldMatchesNameIfNotExist() {
        String text = "Book name not exist";
        assertFalse(book.matches(text));
    }

    @Test
    public void shouldMatchesByAuthorIfExists() {
        String text = "Author1";
        assertTrue(book.matches(text));
    }

    @Test
    public void shouldMatchesByAuthorIfNotExists() {
        String text = "Author not exist";
        assertFalse(book.matches(text));
    }
}
