package com.example.sample_analytics.controller;

import com.example.sample_analytics.dto.filter.TransactionFilter;
import com.example.sample_analytics.entity.Transaction;
import com.example.sample_analytics.exception.ResourceNotFoundException;
import com.example.sample_analytics.service.TransactionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping("/transactions/{id}")
    public ResponseEntity<?> getTransactionById(@PathVariable String id) throws ResourceNotFoundException {
        Transaction transaction = transactionService.getTransactionById(id);

        return new ResponseEntity<>(transaction, HttpStatus.OK);
    }

    @GetMapping("/transactions")
    public ResponseEntity<?> getTransactionList(TransactionFilter filter, Pageable pageable) throws ResourceNotFoundException {
        Page<Transaction> transactionPage = transactionService.getTransactionList(filter, pageable);

        return new ResponseEntity<>(transactionPage, HttpStatus.OK);
    }

    @PostMapping("/transactions")
    public ResponseEntity<?> createTransaction(@RequestBody Transaction transaction) {
        Transaction newTransaction = transactionService.createTransaction(transaction);

        return new ResponseEntity<>(newTransaction, HttpStatus.CREATED);
    }

    @PutMapping("/transactions/{id}")
    public ResponseEntity<?> updateTransaction(@RequestBody Transaction transaction, @PathVariable String id) throws ResourceNotFoundException {
        Transaction newTransaction = transactionService.updateTransaction(transaction);

        return new ResponseEntity<>(newTransaction, HttpStatus.OK);
    }

}