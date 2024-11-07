package com.picpay.picpay.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table (name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotBlank
    private String nomeCompleto;

    @NotBlank
    @Column(unique = true)
    private String cpf;

    @Email
    @NotBlank
    @Column(unique = true)
    private String email;

    @Column(nullable = false)
    private Boolean Lojista;

    @Column(nullable = false)
    @NotBlank
    private String senha;

    @Column(nullable = false)
    private Double saldo;

}
