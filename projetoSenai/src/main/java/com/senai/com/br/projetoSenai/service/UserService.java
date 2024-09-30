package com.senai.com.br.projetoSenai.service;

import com.senai.com.br.projetoSenai.dto.UserResponseDTO;
import com.senai.com.br.projetoSenai.dto.UserSigninDTO;
import com.senai.com.br.projetoSenai.dto.UserSignupDTO;
import com.senai.com.br.projetoSenai.model.User;
import com.senai.com.br.projetoSenai.repository.UserRepository;
import com.senai.com.br.projetoSenai.service.mapper.UserMapper;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Transactional
    public UserResponseDTO signup(@Valid UserSignupDTO userSignupDTO) {
        User entity = this.userMapper.toEntity(userSignupDTO);
        User savedUser = this.userRepository.save(entity);
        return this.userMapper.toDto(savedUser);
    }

    public void signin(@Valid UserSigninDTO userSigninDTO) {
        Optional<User> optUser = userRepository.findByEmailAndPassword(userSigninDTO.email(), userSigninDTO.password());

        if (optUser.isEmpty()) {
            throw new IllegalArgumentException("Email ou senha inválidos");
        }
    }
}
