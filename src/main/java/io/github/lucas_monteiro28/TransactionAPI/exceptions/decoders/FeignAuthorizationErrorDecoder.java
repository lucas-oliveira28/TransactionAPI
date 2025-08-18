package io.github.lucas_monteiro28.TransactionAPI.exceptions.decoders;

import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import feign.codec.ErrorDecoder;
import io.github.lucas_monteiro28.TransactionAPI.dto.request.AuthorizationResponseDTO;
import io.github.lucas_monteiro28.TransactionAPI.exceptions.AuthorizationApiException;

import java.io.IOException;

public class FeignAuthorizationErrorDecoder implements ErrorDecoder {

    private final ObjectMapper objectMapper = new ObjectMapper();
    @Override
    public Exception decode(String methodKey, Response response) {
        try {
            AuthorizationResponseDTO dto = objectMapper.readValue(
                    response.body().asInputStream(),
                    AuthorizationResponseDTO.class
            );
            return new AuthorizationApiException(dto);
        } catch (IOException e) {
            return new RuntimeException("Erro ao chamar API de autorização: " + response.status());
        }
    }

}
