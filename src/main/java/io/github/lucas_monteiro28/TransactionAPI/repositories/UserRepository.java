package io.github.lucas_monteiro28.TransactionAPI.repositories;

import io.github.lucas_monteiro28.TransactionAPI.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findById(Long id);
}
