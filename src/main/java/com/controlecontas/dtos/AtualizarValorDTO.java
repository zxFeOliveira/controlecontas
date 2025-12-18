package com.controlecontas.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record AtualizarValorDTO(
        @NotNull
        @Positive(message = "O valor deve ser positivo")
        BigDecimal valor
) {
}
