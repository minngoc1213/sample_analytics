package com.example.sample_analytics.controller;

import com.example.sample_analytics.dto.TransactionDTO;
import com.example.sample_analytics.dto.filter.TransactionFilter;
import com.example.sample_analytics.dto.mapper.TransactionMapper;
import com.example.sample_analytics.entity.Transaction;
import com.example.sample_analytics.common.exception.ResourceNotFoundException;
import com.example.sample_analytics.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TransactionController {
    private TransactionService transactionService;

    private TransactionMapper transactionMapper;

    public TransactionController(TransactionService transactionService, TransactionMapper transactionMapper) {
        this.transactionService = transactionService;
        this.transactionMapper = transactionMapper;
    }

    @GetMapping("/transactions/{id}")
    public ResponseEntity<?> getTransactionById(@PathVariable String id) throws ResourceNotFoundException {
        Transaction transaction = transactionService.getTransactionById(id);

        return new ResponseEntity<>(transaction, HttpStatus.OK);
    }

    @GetMapping("/transactions")
    public ResponseEntity<?> getTransactionList(TransactionFilter filter, Pageable pageable) throws ResourceNotFoundException {
        List<Transaction> transactionList = transactionService.getTransactionList(filter);
        Page<TransactionDTO> transactionDTOPage = new PageImpl<>(transactionMapper.toDto(transactionList), pageable, transactionList.size());

        return new ResponseEntity<>(transactionDTOPage, HttpStatus.OK);
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