package com.ecommerce.model;

import org.hibernate.validator.constraints.br.CNPJ;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Supplier extends Person{
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Supplier_Id")
    private Long id;
    @NotNull(message = "Nome Fantasia não pode ser nulo!")
    @NotEmpty(message = "Nome Fantasia não pode ser vazio!")
    private String tradingName;
    @CNPJ(message = "CNPJ Inválido!")
    @NotNull(message = "CNPJ não pode ser nulo!")
    private String cnpj;

    @Deprecated
    protected Supplier() {}

    public Supplier(Long id, Contact contact, Address address, String tradingName, String cnpj) {
        super(contact, address);
        this.tradingName = tradingName;
        this.cnpj = cnpj;
        this.id = id;
        isValid();
    }

    public String getTradingName() {
        return tradingName;
    }

    public String getCnpj() {
        return cnpj;
    }

    public Long getId() { return id; }
}
