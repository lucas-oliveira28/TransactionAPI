package io.github.lucas_monteiro28.TransactionAPI.config;

import io.github.lucas_monteiro28.TransactionAPI.exceptions.decoders.FeignAuthorizationErrorDecoder;
import org.springframework.context.annotation.Bean;

public class AuthorizationConfig {

    @Bean
    public FeignAuthorizationErrorDecoder feignAuthorizationErrorDecoder() {
        return new FeignAuthorizationErrorDecoder();
    }

}
