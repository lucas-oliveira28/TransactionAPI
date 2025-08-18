package io.github.lucas_monteiro28.TransactionAPI.dto.response;

import java.time.Instant;
import java.util.UUID;

public record TransactionResponseDTO(

        UUID id,
        Double amount,
        String description,
        String senderName,
        String receiverName,
        Instant timestamp

) {
}
