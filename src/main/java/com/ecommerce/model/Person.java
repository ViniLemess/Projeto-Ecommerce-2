package com.ecommerce.model;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@MappedSuperclass
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Person extends Entity {

    @Valid
    @NotNull(message = "Contato não pode ser nulo!")
    protected Contact contact;
    @Valid
    @NotNull(message = "Endereço não pode ser nulo!")
    protected Address address;

    @Deprecated
    protected Person() {}

    public Person(Contact contact, Address address) {
        this.contact = contact;
        this.address = address;
    }

    public Contact getContact() { return contact; }

    public Address getAddress() {
        return address;
    }
}
