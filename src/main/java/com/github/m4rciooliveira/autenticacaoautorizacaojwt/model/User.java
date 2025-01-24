package com.github.m4rciooliveira.autenticacaoautorizacaojwt.model;

import com.github.m4rciooliveira.autenticacaoautorizacaojwt.model.enums.Role;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.util.Set;
import java.util.UUID;

@Data
@Builder
@Entity
@Table(name = "TB_USERS")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    @Column(unique = true)
    private String email;
    private String password;
    @ElementCollection(targetClass = Role.class)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "role")
    private Set<Role> roles;

}
