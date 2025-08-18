package io.github.lucas_monteiro28.TransactionAPI.dto.request;

import io.github.lucas_monteiro28.TransactionAPI.model.enums.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

public record UserRequestDTO(

        @NotBlank(message = "Name cannot be blank")
        String name,

        @NotBlank(message = "Email cannot be blank")
        @Email(message = "Invalid email")
        String email,

        @NotBlank(message = "Password cannot be blank")
        @Length(min = 8, message = "Password must be at least 8 characters long")
        String password,

        @NotBlank(message = "Role cannot be blank")
        Role role

) {

}
