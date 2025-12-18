package com.controlecontas.exceptions;

public class TipoContaNotFoundException extends RuntimeException {

    public TipoContaNotFoundException(Long id) {
        super("Tipo de conta com id " + id + " não encontrado");
    }
}
