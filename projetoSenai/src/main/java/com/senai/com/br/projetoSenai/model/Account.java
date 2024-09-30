package com.senai.com.br.projetoSenai.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "accounts")
@Data
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(nullable = false)
    private String status;

    @Column(nullable = false)
    private double price;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
