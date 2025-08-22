package io.github.lucas_monteiro28.TransactionAPI.services;

import io.github.lucas_monteiro28.TransactionAPI.dto.request.UserRequestDTO;
import io.github.lucas_monteiro28.TransactionAPI.dto.response.UserResponseDTO;
import io.github.lucas_monteiro28.TransactionAPI.exceptions.RequestNotFoundException;
import io.github.lucas_monteiro28.TransactionAPI.model.User;
import io.github.lucas_monteiro28.TransactionAPI.model.enums.Role;
import io.github.lucas_monteiro28.TransactionAPI.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User buildUserEntity(UserRequestDTO dto) {
        return new User(
                dto.name(), dto.email(), dto.password(),
                Role.valueOf(dto.role()), BigDecimal.valueOf(dto.balance())
        );
    }

    public UserResponseDTO buildUserResponseDTO(User user) {
        return new UserResponseDTO(
                user.getId(), user.getName(), user.getEmail(), user.getRole(), user.getBalance()
        );
    }

    public void saveUser(UserRequestDTO dto) {
        User user = buildUserEntity(dto);
        userRepository.save(user);
    }

    public List<UserResponseDTO> findAllUsers() {
        return userRepository.findAll().stream()
                .map(this::buildUserResponseDTO)
                .toList();
    }

    public void deleteUser(Long id) {
        var user = userRepository.findById(id);
        if (user.isEmpty()) {
            throw new RequestNotFoundException("User not found");
        }
        userRepository.delete(user.get());
    }

}
