package com.ecommerce.model;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@javax.persistence.Entity
public class Order extends Entity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Order_Id")
    private Long id;
    @Valid
    @ManyToOne
    @JoinColumn(name = "Person_Id", updatable = false, insertable = false)
    @NotNull(message = "Cliente não pode ser nulo!")
    private Customer customer;
    @Valid
    @ManyToOne
    @JoinColumn(name = "Person_Id", updatable = false, insertable = false)
    @NotNull(message = "Fornecedor não pode ser nulo!")
    private Supplier supplier;
    @NotNull(message = "Data de compra não pode ser nula!")
    private LocalDateTime purchaseDate;
    @NotNull(message = "Frete não pode ser nulo")
    private Double shippingPrice;
    @OneToMany(mappedBy = "order")
    private List<Item> itemList = new ArrayList<>();

    @Deprecated
    protected Order(){}

    public Order(Long id, Customer customer, Supplier supplier, Double shippingPrice) {
        this.id = id;
        this.customer = customer;
        this.supplier = supplier;
        this.shippingPrice = shippingPrice;
        this.purchaseDate = LocalDateTime.now().withNano(0);
        isValid();
    }

    public void addItem(Item item){ itemList.add(item); }

    public Double getTotalItemsPrice() {

        Double totalItemsPrice = 0.0;
        for(Item item : itemList) {

            totalItemsPrice += item.getTotalItemPrice();
        }
        return totalItemsPrice;
    }
    public Double getTotalPrice() {

        return getTotalItemsPrice() + shippingPrice;
    }

    public Long getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public LocalDateTime getPurchaseDate() {
        return purchaseDate;
    }

    public Double getShippingPrice() {
        return shippingPrice;
    }

    public List<Item> getItemList() {
        return itemList;
    }
}
