package io.github.lucas_monteiro28.TransactionAPI.controllers;

import io.github.lucas_monteiro28.TransactionAPI.config.AuthorizationConfig;
import io.github.lucas_monteiro28.TransactionAPI.dto.request.AuthorizationResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(
        name = "authorization-service",
        url = "https://util.devi.tools/api/v2",
        configuration = AuthorizationConfig.class
)
public interface AuthorizationController {

    @GetMapping("/authorize")
    AuthorizationResponseDTO authorization();

}
