package com.ecommerce.model;

import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Customer extends Person{

    @NotNull(message = "Nome não pode ser nulo!")
    @NotEmpty(message = "Nome não pode ser vazio!")
    private String name;
    @CPF(message = "CPF Invalido!")
    @NotNull(message = "CPF não pode ser nulo!")
    private String cpf;

    @Deprecated
    public Customer() {}

    public Customer(Long id, Contact contact, Address address, String name, String cpf) {
        super(id, contact, address);
        this.name = name;
        this.cpf = cpf;
        isValid();
    }
    public String getName() {
        return name;
    }
    public String getCpf() {
        return cpf;
    }
}
