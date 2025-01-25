package com.github.m4rciooliveira.autenticacaoautorizacaojwt.repository;

import com.github.m4rciooliveira.autenticacaoautorizacaojwt.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    Optional<User> findByEmail(String email);

}
