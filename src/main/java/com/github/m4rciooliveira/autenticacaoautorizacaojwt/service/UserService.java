package com.github.m4rciooliveira.autenticacaoautorizacaojwt.service;

import com.github.m4rciooliveira.autenticacaoautorizacaojwt.config.SecurityConfig;
import com.github.m4rciooliveira.autenticacaoautorizacaojwt.controller.dto.JwtResponseDTO;
import com.github.m4rciooliveira.autenticacaoautorizacaojwt.controller.dto.LoginUserRequestDTO;
import com.github.m4rciooliveira.autenticacaoautorizacaojwt.controller.dto.NewUserRequestDTO;
import com.github.m4rciooliveira.autenticacaoautorizacaojwt.model.User;
import com.github.m4rciooliveira.autenticacaoautorizacaojwt.repository.UserRepository;
import com.github.m4rciooliveira.autenticacaoautorizacaojwt.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final AuthenticationManager authenticationManager;

    private final JwtUtil jwtUtil;

    private final UserRepository userRepository;

    private final SecurityConfig securityConfig;

    public JwtResponseDTO login(LoginUserRequestDTO dto) {

        // Cria um objeto de autenticação com o email e a senha do usuário
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                new UsernamePasswordAuthenticationToken(dto.email(), dto.password());

        // Autentica o usuário com as credenciais fornecidas
        Authentication authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken);

        // Obtém o objeto UserDetails do usuário autenticado
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        // Gera um token JWT para o usuário autenticado
        return new JwtResponseDTO(jwtUtil.generateToken(userDetails));
    }


    public void register(NewUserRequestDTO dto) {

        User user = User.builder()
                .name(dto.name())
                .email(dto.email())
                // Codifica a senha do usuário com o algoritmo bcrypt
                .password(securityConfig.passwordEncoder().encode(dto.password()))
                .roles(dto.roles())
                .build();

        userRepository.save(user);
    }

}
