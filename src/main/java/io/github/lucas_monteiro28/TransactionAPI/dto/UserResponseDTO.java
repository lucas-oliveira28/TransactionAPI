package io.github.lucas_monteiro28.TransactionAPI.dto;

import io.github.lucas_monteiro28.TransactionAPI.model.enums.Role;

public record UserResponseDTO(

        Long id,
        String name,
        String email,
        Role role,
        Double balance

) {
}
