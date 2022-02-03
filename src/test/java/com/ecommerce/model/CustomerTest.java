package com.ecommerce.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    @Test
    public void mustIntantiateCustomerWithSucess() {

        var customerAdress = new Address("Antonio de Carvalho", "385", "Jardim Carvalho", "apto 1603A", "91430-001", "Porto Alegre", "RS");
        var customerContact = new Contact("vini@gmail.com", "51944567738");
        var customer = new Customer(1L, customerContact, customerAdress, "Vinicius", "85246276031");

        Assertions.assertEquals(customerContact, customer.getContact());
        Assertions.assertEquals(customerAdress, customer.getAddress());
        Assertions.assertEquals("85246276031", customer.getCpf());
        Assertions.assertEquals("Vinicius", customer.getName());
    }
    @Test
    public void mustValidateCustomerWithInvalidInstance() {

        try {
            new Customer(1L, null, null, "", "133");
        } catch (Exception exception) {

            Assertions.assertEquals("[address : Endereço não pode ser nulo!, contact : Contato não pode ser nulo!, name : Nome não pode ser vazio!]", exception.getMessage());
        }
    }
}