package com.ecommerce.model;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@javax.persistence.Entity
public class Item extends Entity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Item_Id")
    private Long id;
    @Valid
    @ManyToOne
    @JoinColumn(name = "Product_Id")
    @NotNull(message = "Produto não pode ser nulo!")
    private Product product;
    @NotNull(message = "Quantidade não pode ser nula!")
    private Integer quantity;
    @ManyToOne
    @JoinColumn(name = "Order_Id")
    private Order order;

    @Deprecated
    protected Item(){}

    public Item(Long id, Product product, Integer quantity) {
        this.id = id;
        this.product = product;
        this.quantity = quantity;
    }
    public Long getId() {
        return id;
    }
    public Product getProduct() {
        return product;
    }
    public Integer getQuantity() {
        return quantity;
    }
    public Double getTotalItemPrice() {

        return product.getUnitPrice() * quantity;
    }
    public void setOrder(Order order) {

        this.order = order;
    }
}
