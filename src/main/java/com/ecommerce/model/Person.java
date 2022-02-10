package com.ecommerce.model;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@MappedSuperclass
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Person extends Entity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Person_Id")
    protected Long Id;
    @Valid
    @NotNull(message = "Contato não pode ser nulo!")
    protected Contact contact;
    @Valid
    @NotNull(message = "Endereço não pode ser nulo!")
    protected Address address;

    protected Person() {}

    public Person(Long id, Contact contact, Address address) {
        this.contact = contact;
        this.address = address;
        this.Id = id;
    }

    public Long getId() {
        return Id;
    }

    public Contact getContact() { return contact; }

    public Address getAddress() {
        return address;
    }
}
