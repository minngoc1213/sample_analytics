package com.example.sample_analytics.controller;

import com.example.sample_analytics.domain.Transaction;
import com.example.sample_analytics.repository.TransactionRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/transactions")
@Api(value = "Transaction API")
public class TransactionController {
    @Autowired
    private TransactionRepository transactionRepository;

    @GetMapping("")
    @ApiOperation(value = "Get all transactions", response = Transaction.class)
    public ResponseEntity<?> getAllTransactions(Pageable pageable) {
        Page<Transaction> transactions = transactionRepository.findAll(pageable);

        return new ResponseEntity<>(transactions, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get transaction by ID", response = Transaction.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = Transaction.class),
            @ApiResponse(code = 404, message = "Transaction not found", response = ErrorResponse.class)
    })
    public ResponseEntity<?> getTransactionById(@PathVariable String id) {
        Optional<Transaction> transaction = transactionRepository.findById(id);

        return new ResponseEntity<>(transaction, HttpStatus.OK);
    }

    @PostMapping("")
    @ApiOperation(value = "Create new transaction", response = Void.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Account created successfully", response = Void.class),
            @ApiResponse(code = 500, message = "Error creating account", response = ErrorResponse.class)
    })
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

    @PutMapping("/{id}")
    @ApiOperation(value = "Update transaction by ID", notes = "If transaction not exists, create new transaction", response = Void.class)
    public ResponseEntity<?> updateTransactionById(@PathVariable String id, @RequestBody @Valid Transaction transaction) {
        transactionRepository.save(transaction);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete transaction by ID", response = Void.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Transaction deleted successfully", response = Void.class),
            @ApiResponse(code = 404, message = "Transaction not found", response = ErrorResponse.class)
    })
    public ResponseEntity<?> deleteTransactionById(@PathVariable String id) {
        transactionRepository.deleteById(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
