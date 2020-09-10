package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SmartphoneTest {
    private Smartphone smartphone = new Smartphone(1, "Smartphone name", 300, "Manufacturer1");

    @Test
    public void shouldMatchesNameIfExist() {
        String text = "Smartphone name";
        assertTrue(smartphone.matches(text));
    }

    @Test
    public void shouldMatchesNameIfNotExist() {
        String text = "Smartphone name not exist";
        assertFalse(smartphone.matches(text));
    }

    @Test
    public void shouldMatchesByManufacturerIfExists() {
        String text = "Manufacturer1";
        assertTrue(smartphone.matches(text));
    }

    @Test
    public void shouldMatchesByManufacturerIfNotExists() {
        String text = "Manufacturer not exist";
        assertFalse(smartphone.matches(text));
    }
}
