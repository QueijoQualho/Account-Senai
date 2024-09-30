package com.senai.com.br.projetoSenai.service;

import com.senai.com.br.projetoSenai.dto.AccountRequestDTO;
import com.senai.com.br.projetoSenai.dto.AccountResponseDTO;
import com.senai.com.br.projetoSenai.model.Account;
import com.senai.com.br.projetoSenai.model.User;
import com.senai.com.br.projetoSenai.repository.AccountRepository;
import com.senai.com.br.projetoSenai.repository.UserRepository;
import com.senai.com.br.projetoSenai.service.mapper.AccountMapper;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AccountMapper accountMapper;

    @Autowired
    private UserRepository userRepository;

    public List<AccountResponseDTO> getAllAccounts() {
        return accountRepository.findAll().stream().map(accountMapper::toDto).toList();
    }


    public Optional<AccountResponseDTO> getAccountByID(int id) {
        return accountRepository.findById(id).map(accountMapper::toDto);
    }

    @Transactional
    public AccountResponseDTO createAccount(@Valid AccountRequestDTO accountRequestDTO) {
        System.out.println("userId recebido: " + accountRequestDTO.userId());
        User user = userRepository.findById(accountRequestDTO.userId())
                .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado com ID: " + accountRequestDTO.userId()));

        Account account = accountMapper.toEntity(accountRequestDTO);
        account.setUser(user);
        Account savedAccount = accountRepository.save(account);
        return accountMapper.toDto(savedAccount);
    }

    @Transactional
    public AccountResponseDTO updateAccount(int id, @Valid AccountRequestDTO accountRequestDTO) {
        Account existingAccount = accountRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Conta não encontrada com ID: " + id));

        existingAccount.setPrice(accountRequestDTO.price());
        existingAccount.setStatus(accountRequestDTO.status());

        User user = userRepository.findById(accountRequestDTO.userId())
                .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado com ID: " + accountRequestDTO.userId()));

        existingAccount.setUser(user);

        Account updatedAccount = accountRepository.save(existingAccount);
        return accountMapper.toDto(updatedAccount);
    }


    @Transactional
    public void deleteAccount(int id) {
        if (!accountRepository.existsById(id)) throw new EntityNotFoundException("conta não encontrada: " + id);

        accountRepository.deleteById(id);
    }


}
