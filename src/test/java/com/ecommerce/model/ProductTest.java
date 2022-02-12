package com.ecommerce.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    @Test
    public void mustInstatiateProductWithSuccess() {

        var produto1 = new Product(1L, "Samsung S21", "Celularzão de plastico!", 6553.99);

        Assertions.assertEquals("Samsung S21", produto1.getProductName());
        Assertions.assertEquals("Celularzão de plastico!", produto1.getDescription());
        Assertions.assertEquals(6553.99, produto1.getUnitPrice());
    }
    @Test
    public void mustValidateProductWithNullFields() {

        try {
            new Product(1L, null, null, null);
        } catch (Exception exception) {

            Assertions.assertEquals("[productName : Nome não pode ser nulo!, unitPrice : Preço unitario não pode ser nulo!, productName : Nome não pode ser vazio!]", exception.getMessage());
        }
    }
}