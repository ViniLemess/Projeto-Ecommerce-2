package com.ecommerce.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@javax.persistence.Entity
public class Product extends Entity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Product_Id")
    private Long id;
    @NotNull(message = "Nome não pode ser nulo!")
    @NotEmpty(message = "Nome não pode ser vazio!")
    private String productName;
    @Size(max = 500, message = "Descrição deve ter no máximo 500 caracteres!")
    private String description;
    @NotNull(message = "Preço unitario não pode ser nulo!")
    private Double unitPrice;

    @Deprecated
    protected Product() {}

    public Product(Long id, String productName, String description, Double unitPrice) {
        this.id = id;
        this.productName = productName;
        this.description = description;
        this.unitPrice = unitPrice;
        isValid();
    }

    public Long getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public String getDescription() {
        return description;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }
}
