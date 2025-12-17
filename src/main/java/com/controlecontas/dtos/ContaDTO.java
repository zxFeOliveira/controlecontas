package com.controlecontas.dtos;

import com.controlecontas.domains.TipoConta;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;

public record ContaDTO(
        @NotBlank(message = "O nome é obrigatório")
        String nome,
        @NotBlank(message = "A descrição é obrigatória")
        String observacao,
        @NotNull(message = "O valor não pode ser nulo")
        BigDecimal valor,
        @NotNull(message = "Informe o vencimento da conta")
        LocalDate vencimento,
        @NotNull(message = "Tipo de conta obrigatório")
        TipoConta tipoConta){
}
