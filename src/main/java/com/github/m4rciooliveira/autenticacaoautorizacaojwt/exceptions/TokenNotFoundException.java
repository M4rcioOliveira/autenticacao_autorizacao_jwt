package com.github.m4rciooliveira.autenticacaoautorizacaojwt.exceptions;

public class TokenNotFoundException extends RuntimeException{

    public TokenNotFoundException() {
        super("Token não encontrado!");
    }

}
