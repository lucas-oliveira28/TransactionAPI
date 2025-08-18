package io.github.lucas_monteiro28.TransactionAPI.dto.request;

import io.github.lucas_monteiro28.TransactionAPI.dto.DataDTO;

public record AuthorizationResponseDTO(
        String status,
        DataDTO data
) {
}
