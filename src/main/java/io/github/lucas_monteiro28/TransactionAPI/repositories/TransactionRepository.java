package io.github.lucas_monteiro28.TransactionAPI.repositories;

import io.github.lucas_monteiro28.TransactionAPI.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TransactionRepository extends JpaRepository<Transaction, UUID> {
}
