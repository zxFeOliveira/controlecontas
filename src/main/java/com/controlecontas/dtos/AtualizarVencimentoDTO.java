package com.controlecontas.dtos;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record AtualizarVencimentoDTO(
        @NotNull
        @Future(message = "O vencimento deve ser uma data futura")
        LocalDate vencimento
) {}