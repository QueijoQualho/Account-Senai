package com.senai.com.br.projetoSenai.service.mapper;

import com.senai.com.br.projetoSenai.dto.UserResponseDTO;
import com.senai.com.br.projetoSenai.dto.UserSignupDTO;
import com.senai.com.br.projetoSenai.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserResponseDTO toDto(User entity);
    User toEntity(UserSignupDTO dto);
}
