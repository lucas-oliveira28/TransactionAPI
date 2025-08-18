package io.github.lucas_monteiro28.TransactionAPI.exceptions;

import io.github.lucas_monteiro28.TransactionAPI.dto.request.AuthorizationResponseDTO;
import lombok.Getter;

@Getter
public class AuthorizationApiException extends RuntimeException {
    private final AuthorizationResponseDTO responseDTO;

    public AuthorizationApiException(AuthorizationResponseDTO dto) {
        super("Erro na autorização externa: " + dto.status());
        this.responseDTO = dto;
    }
}
