package com.example.sample_analytics.controller;

import com.example.sample_analytics.domain.Transaction;
import com.example.sample_analytics.repository.TransactionRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
public class TransactionController {
    @Autowired
    private TransactionRepository transactionRepository;

    // Return all transactions
    @GetMapping("/transactions")
    public ResponseEntity<?> getAllTransactions(Pageable pageable) {
        Page<Transaction> transactions = transactionRepository.findAll(pageable);

        return new ResponseEntity<>(transactions, HttpStatus.OK);
    }

    // Return a transaction by id
    @GetMapping("/transactions/{id}")
    public ResponseEntity<?> getTransactionById(@PathVariable String id) {
        Optional<Transaction> transaction = transactionRepository.findById(id);

        return new ResponseEntity<>(transaction, HttpStatus.OK);
    }

    // Create a transaction
    @PostMapping("/transactions")
    public ResponseEntity<?> createTransaction(@RequestBody @Valid Transaction transaction) {
        transactionRepository.save(transaction);

        HttpHeaders responseHeaders = new HttpHeaders();

        URI newTransactionUri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(transaction.getId())
                .toUri();

        responseHeaders.setLocation(newTransactionUri);

        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }

    // Update a transaction by id
    @PutMapping("/transactions/{id}")
    public ResponseEntity<?> updateTransactionById(@PathVariable String id, @RequestBody @Valid Transaction transaction) {
        transactionRepository.save(transaction);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    // Delete a transaction by id
    @DeleteMapping("/transactions/{id}")
    public ResponseEntity<?> deleteTransactionById(@PathVariable String id) {
        transactionRepository.deleteById(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
