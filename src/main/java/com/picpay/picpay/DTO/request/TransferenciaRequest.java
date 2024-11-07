package com.picpay.picpay.DTO.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class TransferenciaRequest {

    @Schema(description = "ID do usuário pagador", example = "4")
    private Long payerId;

    @Schema(description = "ID do usuário recebedor", example = "15")
    private Long payeeId;

    @Schema(description = "Valor da transferência", example = "100.0")
    private Double valor;
}
