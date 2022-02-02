package com.ecommerce.infra.exceptions;

public class GenericBusinessException extends RuntimeException {
    public GenericBusinessException(String message) {
        super(message);
    }
}
