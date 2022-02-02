package com.ecommerce.infra.exceptions;

import java.util.Set;

public class InvalidDomainException extends GenericBusinessException {

    public InvalidDomainException(Set<String> mensagens) {
        super(mensagens.toString());
    }
    public InvalidDomainException(String mensagem) {
        super(mensagem);
    }
}
