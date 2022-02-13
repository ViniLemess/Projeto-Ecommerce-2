package com.ecommerce.model;

import com.ecommerce.infra.exceptions.GenericBusinessException;

import javax.persistence.Entity;
import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class OrderModel extends com.ecommerce.model.Entity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Order_Id")
    private Long id;

    @Valid
    @ManyToOne
    @JoinColumn(name = "Customer_Id")
    @NotNull(message = "Cliente não pode ser nulo!")
    private Customer customer;

    @Valid
    @ManyToOne
    @JoinColumn(name = "Supplier_Id")
    @NotNull(message = "Fornecedor não pode ser nulo!")
    private Supplier supplier;

    @NotNull(message = "Data de compra não pode ser nula!")
    private LocalDateTime purchaseDate;

    @NotNull(message = "Frete não pode ser nulo")
    private Double shippingPrice;

    @OneToMany(mappedBy = "orderModel", cascade = {CascadeType.ALL})
    private List<Item> itemList = new ArrayList<>();

    @Deprecated
    protected OrderModel(){}

    public OrderModel(Long id, Customer customer, Supplier supplier, Double shippingPrice, Item item) {
        this.id = id;
        this.customer = customer;
        this.supplier = supplier;
        this.shippingPrice = shippingPrice;
        this.purchaseDate = LocalDateTime.now().withNano(0);
        this.addItem(item);
        isValid();
    }

    public void addItem(Item item){

        if(item == null) {return;}
        item.setOrder(this);
        this.itemList.add(item);
    }

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
