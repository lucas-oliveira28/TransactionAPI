package io.github.lucas_monteiro28.TransactionAPI.controllers;

import io.github.lucas_monteiro28.TransactionAPI.dto.request.TransactionRequestDTO;
import io.github.lucas_monteiro28.TransactionAPI.dto.response.TransactionResponseDTO;
import io.github.lucas_monteiro28.TransactionAPI.services.TransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping("/new")
    public ResponseEntity<String> newTransaction(@RequestBody TransactionRequestDTO dto) {
        transactionService.saveTransaction(dto);
        return ResponseEntity.ok("Transaction saved successfully");
    }

    @GetMapping("/all")
    public ResponseEntity<List<TransactionResponseDTO>> findAllTransactions() {
        return ResponseEntity.ok(transactionService.findAllTransactions());
    }

}
