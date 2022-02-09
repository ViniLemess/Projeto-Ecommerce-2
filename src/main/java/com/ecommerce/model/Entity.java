package com.ecommerce.model;

import com.ecommerce.infra.exceptions.InvalidDomainException;

import javax.persistence.MappedSuperclass;
import javax.validation.*;
import java.util.HashSet;
import java.util.Set;

@MappedSuperclass
public abstract  class Entity {
    void isValid() {
        Configuration<?> configurations = Validation.byDefaultProvider().configure();
        ValidatorFactory fabric = configurations.buildValidatorFactory();
        Validator validador = fabric.getValidator();
        Set<ConstraintViolation<Entity>> violations = validador.validate(this);

        Set<String> messages = new HashSet<>();

        for (ConstraintViolation<Entity> constraintViolation : violations) {
            String campo = constraintViolation.getPropertyPath().toString();
            String msg = constraintViolation.getMessage();
            messages.add(campo.concat(" : ").concat(msg));
        }

        if (!messages.isEmpty()) {
            throw new InvalidDomainException(messages);
        }
    }
}
