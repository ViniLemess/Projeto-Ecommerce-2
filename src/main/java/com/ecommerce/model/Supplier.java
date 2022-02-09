package com.ecommerce.model;

import org.hibernate.validator.constraints.br.CNPJ;

import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Supplier extends Person{

    @NotNull(message = "Nome Fantasia não pode ser nulo!")
    @NotEmpty(message = "Nome Fantasia não pode ser vazio!")
    private String tradingName;
    @CNPJ(message = "CNPJ Inválido!")
    @NotNull(message = "CNPJ não pode ser nulo!")
    private String cnpj;

    protected Supplier() {}

    public Supplier(Long id, Contact contact, Address address, String tradingName, String cnpj) {
        super(id, contact, address);
        this.tradingName = tradingName;
        this.cnpj = cnpj;
        isValid();
    }

    public String getTradingName() {
        return tradingName;
    }

    public String getCnpj() {
        return cnpj;
    }
}
