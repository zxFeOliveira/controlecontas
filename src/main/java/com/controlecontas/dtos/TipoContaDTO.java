package com.controlecontas.dtos;

import jakarta.validation.constraints.NotBlank;

public record TipoContaDTO(
        @NotBlank(message = "O nome do tipo da conta é obrigatório")
        String nome,
        @NotBlank(message = "A descrição do tipo da conta é obrigatório")
        String descricao) {
}
