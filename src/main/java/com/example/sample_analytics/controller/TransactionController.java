package com.example.sample_analytics.controller;

import com.example.sample_analytics.common.exception.ResourceNotFoundException;
import com.example.sample_analytics.dto.TransactionDTO;
import com.example.sample_analytics.dto.filter.TransactionFilter;
import com.example.sample_analytics.dto.mapper.TransactionMapper;
import com.example.sample_analytics.entity.Transaction;
import com.example.sample_analytics.service.TransactionService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
public class TransactionController {
    private final TransactionService transactionService;

    private final TransactionMapper transactionMapper;

    public TransactionController(TransactionService transactionService, TransactionMapper transactionMapper) {
        this.transactionService = transactionService;
        this.transactionMapper = transactionMapper;
    }

    @GetMapping("/transactions/{id}")
    public ResponseEntity<?> getTransactionById(@PathVariable @Valid String id) throws ResourceNotFoundException {
        Transaction transaction = transactionService.getTransactionById(id);

        return new ResponseEntity<>(transaction, HttpStatus.OK);
    }

    @GetMapping("/transactions")
    public ResponseEntity<?> getTransactionList(TransactionFilter filter, Pageable pageable) {
        Page<Transaction> transactionPage = transactionService.getTransactionList(filter, pageable);
        Page<TransactionDTO> transactionDTOPage = transactionPage.map(this.transactionMapper::toDto);

        return new ResponseEntity<>(transactionDTOPage, HttpStatus.OK);
    }

    @PostMapping("/transactions")
    public ResponseEntity<?> createTransaction(@RequestBody @Valid Transaction transaction) {
        Transaction newTransaction = transactionService.createTransaction(transaction);

        return new ResponseEntity<>(newTransaction, HttpStatus.CREATED);
    }

    @PutMapping("/transactions")
    public ResponseEntity<?> updateTransaction(@RequestBody @Valid Transaction transaction) throws ResourceNotFoundException {
        Transaction newTransaction = transactionService.updateTransaction(transaction);

        return new ResponseEntity<>(newTransaction, HttpStatus.OK);
    }

    @DeleteMapping("/transactions/{id}")
    public ResponseEntity<?> deleteTransaction(@PathVariable @Valid String id) throws ResourceNotFoundException {
        transactionService.deleteTransaction(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}