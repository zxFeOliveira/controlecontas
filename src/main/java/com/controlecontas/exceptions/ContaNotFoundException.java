package com.controlecontas.exceptions;

//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.ResponseStatus;

//@ResponseStatus(HttpStatus.NOT_FOUND)
public class ContaNotFoundException extends RuntimeException {

    public ContaNotFoundException(Long id) {
        super("Conta com id " + id + " não encontrada");
    }
}