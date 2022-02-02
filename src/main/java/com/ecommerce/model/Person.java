package com.ecommerce.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@MappedSuperclass
public abstract class Person extends Entity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long Id;
    @Valid
    @NotNull(message = "Contato não pode ser nulo!")
    protected Contact contact;
    @Valid
    @NotNull(message = "Endereço não pode ser nulo!")
    protected Address address;

    @Deprecated
    public Person() {}

    public Person(Long id, Contact contact, Address address) {
        this.contact = contact;
        this.address = address;
        this.Id = id;
        isValid();
    }

    public Long getId() {
        return Id;
    }

    public Contact getContact() { return contact; }

    public Address getAddress() {
        return address;
    }
}
