package com.github.m4rciooliveira.autenticacaoautorizacaojwt.controller.dto;

import com.github.m4rciooliveira.autenticacaoautorizacaojwt.model.enums.Role;

import java.util.Set;

public record NewUserRequestDTO(
        String name,
        String email,
        String password,
        Set<Role> roles
) {
}
