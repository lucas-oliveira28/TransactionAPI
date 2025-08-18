package io.github.lucas_monteiro28.TransactionAPI.repositories;

import io.github.lucas_monteiro28.TransactionAPI.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
