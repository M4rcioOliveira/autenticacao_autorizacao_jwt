package com.github.m4rciooliveira.autenticacaoautorizacaojwt.service;

import com.github.m4rciooliveira.autenticacaoautorizacaojwt.exceptions.UserNotFoundException;
import com.github.m4rciooliveira.autenticacaoautorizacaojwt.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user = userRepository.findByEmail(username).orElseThrow(UserNotFoundException::new);
        return new UserDetailsImpl(user);
    }

}
