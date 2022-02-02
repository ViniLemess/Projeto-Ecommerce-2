package com.ecommerce.model;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Embeddable
public class Address {

    @NotNull(message = "Street cannot be null!")
    @NotEmpty(message = "Street cannot be empty!")
    @Size(max = 100, message = "Numero maximo de caracteres permitido é 100!")
    private String street;
    private String number = null;
    @NotNull(message = "Neighbourhood cannot be null!")
    @NotEmpty(message = "Neighbourhood cannot be empty!")
    @Size(max = 50, message = "Numero maximo de caracteres permitido é 50!")
    private String neighbourhood;
    @Size(max = 120, message = "Numero maximo de caracteres permitido é 120!")
    private String complement = null;
    @NotNull(message = "Zipcode cannot be null!")
    @NotEmpty(message = "Zipcode cannot be empty!")
    @Size(max = 10, message = "Numero maximo de caracteres permitido é 10!")
    private String zipcode;
    @NotNull(message = "City cannot be null!")
    @NotEmpty(message = "Zipcode cannot be empty!")
    @Size(max = 20, message = "Numero maximo de caracteres permitido é 50!")
    private String city;
    @NotNull(message = "State cannot be null!")
    @NotEmpty(message = "Zipcode cannot be empty!")
    @Size(max = 2, message = "Numero maximo de caracteres permitido é 2!")
    private String state;

    public Address(String street, String number, String neighbourhood, String complement, String zipcode, String city, String state) {
        this.street = street;
        this.number = number;
        this.neighbourhood = neighbourhood;
        this.complement = complement;
        this.zipcode = zipcode;
        this.city = city;
        this.state = state;
    }

    @Deprecated
    public Address() {}

    public String getStreet() {
        return street;
    }

    public String getNumber() {
        return number;
    }

    public String getNeighbourhood() {
        return neighbourhood;
    }

    public String getComplement() {
        return complement;
    }

    public String getZipcode() {
        return zipcode;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }
}
