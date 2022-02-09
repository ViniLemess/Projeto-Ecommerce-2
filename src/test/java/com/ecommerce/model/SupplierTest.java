package com.ecommerce.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SupplierTest {

    @Test
    public void mustInstantiateSupplierWithSucess() {

        var companyAddres = new Address("Protasio Alves", "385", "Alto Petropolis", "Décimo Andar", "95345-000", "Porto Alegre", "RS");
        var companyContact = new Contact("RV51@gmail.com", "51944567738");
        var company = new Supplier(1L, companyContact, companyAddres, "RV51", "22445956000130");

        Assertions.assertEquals(companyAddres, company.getAddress());
        Assertions.assertEquals(companyContact, company.getContact());
        Assertions.assertEquals("RV51", company.getTradingName());
        Assertions.assertEquals("22445956000130", company.getCnpj());
    }
    @Test
    public void mustValidateSupplierWithInvalidInstance() {

        try {
            new Supplier(1L, null, null, "", "111");
        } catch (Exception exception) {

            Assertions.assertEquals("[cnpj : CNPJ Inválido!, address : Endereço não pode ser nulo!, contact : Contato não pode ser nulo!, tradingName : Nome Fantasia não pode ser vazio!]", exception.getMessage());
        }
    }
}