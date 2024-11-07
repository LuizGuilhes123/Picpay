package com.picpay.picpay.exceptions;

import com.picpay.picpay.DTO.response.TransferenciaResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<TransferenciaResponse> handleIllegalArgument(IllegalArgumentException ex) {
        TransferenciaResponse response = new TransferenciaResponse(
                "falha",  // Status da falha
                ex.getMessage(),  // Mensagem detalhada do erro
                null,  // Não precisamos de dados do pagador ou recebedor aqui
                null,
                null
        );
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
