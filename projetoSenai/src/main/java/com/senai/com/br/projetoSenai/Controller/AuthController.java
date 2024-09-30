package com.senai.com.br.projetoSenai.controller;

import com.senai.com.br.projetoSenai.service.UserService;
import com.senai.com.br.projetoSenai.dto.UserResponseDTO;
import com.senai.com.br.projetoSenai.dto.UserSigninDTO;
import com.senai.com.br.projetoSenai.dto.UserSignupDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<UserResponseDTO> signup(@RequestBody @Valid UserSignupDTO userSignupDTO) {
        UserResponseDTO userResponseDTO = this.userService.signup(userSignupDTO);
        return new ResponseEntity<>(userResponseDTO, HttpStatus.CREATED);
    }

    @PostMapping("/signin")
    public ResponseEntity<?> signin(@RequestBody @Valid UserSigninDTO userSigninDTO) {
        this.userService.signin(userSigninDTO);
        return ResponseEntity.noContent().build();
    }
}
