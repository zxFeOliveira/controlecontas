package com.controlecontas.dtos;

import java.time.LocalDateTime;

public record ErrorResponseDTO(
        int status,
        String message,
        String path,
        LocalDateTime timestamp
) {
    public ErrorResponseDTO(int status, String message, String path) {
        this(status, message, path, LocalDateTime.now());
    }
}