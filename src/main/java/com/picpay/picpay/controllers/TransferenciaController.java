package com.picpay.picpay.controllers;


import com.picpay.picpay.DTO.request.TransferenciaRequest;
import com.picpay.picpay.DTO.response.TransferenciaResponse;
import com.picpay.picpay.service.TransferenciaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transferencias")
@Tag(name = "Transferências", description = "Operações de transferência entre usuários e lojistas")
public class TransferenciaController {

    @Autowired
    private TransferenciaService transferenciaService;

    @Operation(summary = "Realiza uma transferência entre usuários",
            description = "Efetua uma transferência entre um pagador e um recebedor, com verificação de saldo e regras específicas para lojistas.")
    @PostMapping
    public ResponseEntity<TransferenciaResponse> transferir(@RequestBody TransferenciaRequest request) {
        TransferenciaResponse response = transferenciaService.transferir(
                request.getPayerId(), request.getPayeeId(), request.getValor());
        return ResponseEntity.ok(response);
    }
}
