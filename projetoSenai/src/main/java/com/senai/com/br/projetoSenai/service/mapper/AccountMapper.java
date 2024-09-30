package com.senai.com.br.projetoSenai.service.mapper;

import com.senai.com.br.projetoSenai.dto.AccountRequestDTO;
import com.senai.com.br.projetoSenai.dto.AccountResponseDTO;
import com.senai.com.br.projetoSenai.model.Account;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AccountMapper {

    @Mapping(source = "user.id", target = "userId")  // Extrai o ID do objeto User
    AccountResponseDTO toDto(Account account);

    @Mapping(source = "userId", target = "user.id")  // Mapear o userId ao criar a Account
    Account toEntity(AccountRequestDTO accountRequestDTO);
}
