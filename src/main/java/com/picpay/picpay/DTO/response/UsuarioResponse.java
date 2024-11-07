package com.picpay.picpay.DTO.response;

import lombok.Data;
import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor
public class UsuarioResponse {
    private Long id;
    private String nomeCompleto;
    private String cpf;
    private String email;
    private Boolean Lojista;
    private Double saldo;
}
