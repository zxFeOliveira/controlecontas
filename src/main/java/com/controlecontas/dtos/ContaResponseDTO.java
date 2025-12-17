package com.controlecontas.dtos;

import java.math.BigDecimal;
import java.time.LocalDate;

public record ContaResponseDTO(Long id,
                               String nome,
                               String observacao,
                               BigDecimal valor,
                               LocalDate vencimento,
                               String statusConta,
                               String tipoNome) {
}
