package com.github.m4rciooliveira.autenticacaoautorizacaojwt.controller;

import com.github.m4rciooliveira.autenticacaoautorizacaojwt.controller.dto.JwtResponseDTO;
import com.github.m4rciooliveira.autenticacaoautorizacaojwt.controller.dto.LoginUserRequestDTO;
import com.github.m4rciooliveira.autenticacaoautorizacaojwt.controller.dto.NewUserRequestDTO;
import com.github.m4rciooliveira.autenticacaoautorizacaojwt.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UseController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<Void> register(@RequestBody NewUserRequestDTO dto) {
        userService.register(dto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping
    public ResponseEntity<JwtResponseDTO> login(@RequestBody LoginUserRequestDTO dto) {
        return new ResponseEntity<>(userService.login(dto), HttpStatus.OK);
    }

    @GetMapping("/test")
    public ResponseEntity<String> test() {
        return new ResponseEntity<>("Todos Podem Acessar!", HttpStatus.OK);
    }

    @GetMapping("/test/dev")
    public ResponseEntity<String> testDEV() {
        return new ResponseEntity<>("Olá Dev!", HttpStatus.OK);
    }

    @GetMapping("/test/hml")
    public ResponseEntity<String> testHML() {
        return new ResponseEntity<>("Olá Hml!", HttpStatus.OK);
    }

}
