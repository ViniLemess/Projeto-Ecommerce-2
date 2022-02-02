package com.ecommerce.model;

import com.ecommerce.infra.exceptions.InvalidDomainException;

import javax.persistence.MappedSuperclass;
import javax.validation.*;
import java.util.HashSet;
import java.util.Set;

@MappedSuperclass
public abstract  class Entity {
    void isValid() {
        Configuration<?> configuracaoes = Validation.byDefaultProvider().configure();
        ValidatorFactory fabrica = configuracaoes.buildValidatorFactory();
        Validator validador = fabrica.getValidator();
        Set<ConstraintViolation<Entity>> regrasVioladas = validador.validate(this);

        Set<String> mensagens = new HashSet<>();

        for (ConstraintViolation<Entity> constraintViolation : regrasVioladas) {
            String campo = constraintViolation.getPropertyPath().toString();
            String msg = constraintViolation.getMessage();
            mensagens.add(campo.concat(" : ").concat(msg));
        }

        if (!mensagens.isEmpty()) {
            throw new InvalidDomainException(mensagens);
        }
    }
}
