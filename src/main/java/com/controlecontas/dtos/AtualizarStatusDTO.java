package com.controlecontas.dtos;

import com.controlecontas.enums.StatusConta;
import jakarta.validation.constraints.NotNull;

public record AtualizarStatusDTO(
        @NotNull
        StatusConta status)
{ }
