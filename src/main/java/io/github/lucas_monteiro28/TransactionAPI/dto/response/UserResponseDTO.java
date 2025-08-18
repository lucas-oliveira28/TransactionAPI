package io.github.lucas_monteiro28.TransactionAPI.dto.response;

import io.github.lucas_monteiro28.TransactionAPI.model.enums.Role;

import java.math.BigDecimal;

public record UserResponseDTO(

        Long id,
        String name,
        String email,
        Role role,
        BigDecimal balance

) {
}
