package io.github.lucas_monteiro28.TransactionAPI.services;

import io.github.lucas_monteiro28.TransactionAPI.dto.request.TransactionRequestDTO;
import io.github.lucas_monteiro28.TransactionAPI.dto.response.TransactionResponseDTO;
import io.github.lucas_monteiro28.TransactionAPI.exceptions.RequestErrorException;
import io.github.lucas_monteiro28.TransactionAPI.model.Transaction;
import io.github.lucas_monteiro28.TransactionAPI.model.User;
import io.github.lucas_monteiro28.TransactionAPI.model.enums.Role;
import io.github.lucas_monteiro28.TransactionAPI.repositories.TransactionRepository;
import io.github.lucas_monteiro28.TransactionAPI.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final UserRepository userRepository;

    @Autowired
    public TransactionService(TransactionRepository transactionRepository, UserRepository userRepository) {
        this.transactionRepository = transactionRepository;
        this.userRepository = userRepository;
    }

    private Transaction buildTransactionEntity(TransactionRequestDTO dto) {
        Optional<User> receiver = userRepository.findById(dto.receiverId());
        Optional<User> sender = userRepository.findById(dto.senderId());
        if (receiver.isEmpty() || sender.isEmpty()) {
            throw new IllegalArgumentException("User not found");
        }
        return new Transaction(
                BigDecimal.valueOf(dto.amount()),
                dto.description(), Instant.now(),
                sender.get(), receiver.get()
        );
    }

    private TransactionResponseDTO buildTransactionResponseDTO(Transaction transaction) {
        return new TransactionResponseDTO(
                transaction.getId(),
                transaction.getAmount(),
                transaction.getDescription(),
                transaction.getSender().getName(),
                transaction.getReceiver().getName(),
                transaction.getDate()
        );
    }

    public void saveTransaction(TransactionRequestDTO dto) {
        Transaction transaction = buildTransactionEntity(dto);
        debt(transaction);
        transactionRepository.save(transaction);
    }

    public List<TransactionResponseDTO> findAllTransactions() {
        return transactionRepository.findAll().stream()
                .map(this::buildTransactionResponseDTO)
                .toList();
    }

    private void debt(Transaction transaction) {
        if (transaction.getAmount().compareTo(BigDecimal.ZERO) <= 0) {
            throw new RequestErrorException("Amount must be greater than zero");
        }
        if (transaction.getSender().getId().equals(transaction.getReceiver().getId())) {
            throw new RequestErrorException("Sender and receiver cannot be the same");
        }
        if (transaction.getAmount().compareTo(transaction.getSender().getBalance()) > 0) {
            throw new RequestErrorException("Insufficient balance");
        }
        if (transaction.getSender().getRole().equals(Role.MERCHANT)) {
            throw new RequestErrorException("Merchant cannot send money");
        }
        transaction.getSender().setBalance(transaction.getSender().getBalance().subtract(transaction.getAmount()));
        transaction.getReceiver().setBalance(transaction.getReceiver().getBalance().add(transaction.getAmount()));
        userRepository.save(transaction.getSender());
        userRepository.save(transaction.getReceiver());
    }

}
