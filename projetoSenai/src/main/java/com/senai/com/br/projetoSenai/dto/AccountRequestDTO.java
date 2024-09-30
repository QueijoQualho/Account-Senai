package com.senai.com.br.projetoSenai.dto;

public record AccountRequestDTO(
        double price,
        String status,
        Integer userId
) { }
