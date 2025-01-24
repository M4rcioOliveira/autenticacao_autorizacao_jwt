package com.github.m4rciooliveira.autenticacaoautorizacaojwt.controller.dto;

public record LoginUserRequestDTO(
        String email,
        String password
) {
}
