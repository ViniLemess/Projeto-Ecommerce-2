package com.ecommerce.model;

import javax.persistence.Embeddable;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Embeddable
public class Contact {

    @NotNull(message = "Email não pode ser nulo!")
    @NotEmpty(message = "Email não pode ser vazio!")
    @Size(max = 100, message = "Numero maximo de caracteres permitido é 100!")
    private String email;

    @NotNull(message = "Telefone não pode ser nulo!")
    @NotEmpty(message = "Telefone não pode ser vazio!")
    @Size(max = 20, message = "Numero maximo de caracteres permitido é 20!")
    private String phoneNumber;

    @Deprecated
    protected Contact(){}

    public Contact(String email, String phoneNumber) {
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
