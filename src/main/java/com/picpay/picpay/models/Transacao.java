package com.picpay.picpay.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "transacoes")
public class Transacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Double valor;

    @ManyToOne
    @JoinColumn(name = "payer_id")
    private Usuario payer;

    @ManyToOne
    @JoinColumn(name = "payee_id")
    private Usuario payee;
}
