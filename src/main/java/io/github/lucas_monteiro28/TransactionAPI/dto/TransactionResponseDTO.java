package io.github.lucas_monteiro28.TransactionAPI.dto;

import io.github.lucas_monteiro28.TransactionAPI.model.User;

import java.time.Instant;
import java.util.UUID;

public record TransactionResponseDTO(

        UUID id,
        Double amount,
        String description,
        User sender,
        User receiver,
        Instant timestamp

) {
}
