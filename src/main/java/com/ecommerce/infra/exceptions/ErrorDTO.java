package com.ecommerce.infra.exceptions;

public class ErrorDTO {

    private String key;
    private String message;

    public ErrorDTO(String key, String message) {
        this.key = key;
        this.message = message;
    }

    public String getKey() {
        return key;
    }

    public String getMessage() {
        return message;
    }
}
