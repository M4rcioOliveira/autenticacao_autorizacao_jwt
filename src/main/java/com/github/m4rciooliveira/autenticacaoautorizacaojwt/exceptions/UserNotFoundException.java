package com.github.m4rciooliveira.autenticacaoautorizacaojwt.exceptions;

public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException() {
        super("Usuário não encontrado!");
    }

}
