package io.github.lucas_monteiro28.TransactionAPI.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public record TransactionRequestDTO(

        @NotNull(message = "Amount cannot be null")
        Double amount,

        @NotBlank(message = "Description cannot be blank")
        @Length(min = 10, message = "Description must be at least 10 characters long")
        String description,

        @NotNull(message = "Sender ID cannot be null")
        Long senderId,

        @NotNull(message = "Receiver ID cannot be null")
        Long receiverId

) {
}
