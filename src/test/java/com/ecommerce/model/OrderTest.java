package com.ecommerce.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    @Test
    public void mustInstatiateOrderWithSucess() {
        var customerAdress = new Address("Antonio de Carvalho", "385", "Jardim Carvalho", "apto 1603A", "91430-001", "Porto Alegre", "RS");
        var customerContact = new Contact("vini@gmail.com", "51944567738");
        var customer = new Customer(1L, customerContact, customerAdress, "Vinicius", "85246276031");

        var companyAddres = new Address("Protasio Alves", "385", "Alto Petropolis", "Décimo Andar", "95345-000", "Porto Alegre", "RS");
        var companyContact = new Contact("RV51@gmail.com", "51944567738");
        var company = new Supplier(1L, companyContact, companyAddres, "RV51", "22445956000130");

        var produto1 = new Product(1L, "Samsung S21", "Celularzão do BTS!", 6553.99);
        var item1 = new Item(1L, produto1, 5);

        Order order1 = new Order(1L, customer, company, 5.5, item1);

        Assertions.assertEquals(customer, order1.getCustomer());
        Assertions.assertEquals(company, order1.getSupplier());
        Assertions.assertEquals(5.5, order1.getShippingPrice());
        Assertions.assertEquals(1, order1.getItemList().size());
    }
    @Test
    public void mustReturnTotalItemsPriceWithSuccess(){

        var customerAdress = new Address("Antonio de Carvalho", "385", "Jardim Carvalho", "apto 1603A", "91430-001", "Porto Alegre", "RS");
        var customerContact = new Contact("vini@gmail.com", "51944567738");
        var customer = new Customer(1L, customerContact, customerAdress, "Vinicius", "85246276031");

        var companyAddres = new Address("Protasio Alves", "385", "Alto Petropolis", "Décimo Andar", "95345-000", "Porto Alegre", "RS");
        var companyContact = new Contact("RV51@gmail.com", "51944567738");
        var company = new Supplier(1L, companyContact, companyAddres, "RV51", "22445956000130");

        var produto1 = new Product(1L, "Samsung S21", "Celularzão do BTS!", 6553.99);
        var item1 = new Item(1L, produto1, 5);

        Order order1 = new Order(1L, customer, company, 32.5, item1);

        Assertions.assertEquals(32769.95, order1.getTotalItemsPrice(), 2);
    }
    @Test
    public void mustReturnTotalPriceWithSuccess(){

        var customerAdress = new Address("Antonio de Carvalho", "385", "Jardim Carvalho", "apto 1603A", "91430-001", "Porto Alegre", "RS");
        var customerContact = new Contact("vini@gmail.com", "51944567738");
        var customer = new Customer(1L, customerContact, customerAdress, "Vinicius", "85246276031");

        var companyAddres = new Address("Protasio Alves", "385", "Alto Petropolis", "Décimo Andar", "95345-000", "Porto Alegre", "RS");
        var companyContact = new Contact("RV51@gmail.com", "51944567738");
        var company = new Supplier(1L, companyContact, companyAddres, "RV51", "22445956000130");

        var produto1 = new Product(1L, "Samsung S21", "Celularzão do BTS!", 6553.99);
        var item1 = new Item(1L, produto1, 5);

        Order order1 = new Order(1L, customer, company, 32.5, item1);

        Assertions.assertEquals(32802.45, order1.getTotalPrice(), 2);
    }
}