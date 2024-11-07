package com.picpay.picpay.DTO.request;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioRequest {
    private String nomeCompleto;
    private String cpf;
    private String email;
    private String senha;
    private Boolean Lojista;
    private Double saldoInicial;
}
