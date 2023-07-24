package com.example.sample_analytics.web.controller;

import com.example.sample_analytics.common.exception.ResourceNotFoundException;
import com.example.sample_analytics.user.dto.TransactionDTO;
import com.example.sample_analytics.user.dto.filter.TransactionFilter;
import com.example.sample_analytics.user.dto.mapper.TransactionMapper;
import com.example.sample_analytics.user.entity.Transaction;
import com.example.sample_analytics.user.service.TransactionService;
import com.example.sample_analytics.web.response.APIResponse;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public APIResponse<TransactionDTO> getTransactionById(@PathVariable @Valid String id) throws ResourceNotFoundException {
        Transaction transaction = transactionService.getTransactionById(id);

        return APIResponse.newSuccessResponse(this.transactionMapper.toDto(transaction));
    }

    @GetMapping("/transactions")
    public APIResponse<List<TransactionDTO>> getTransactionList(TransactionFilter filter, Pageable pageable) {
        Page<Transaction> transactionPage = transactionService.getTransactionList(filter, pageable);
        Page<TransactionDTO> transactionDTOPage = transactionPage.map(this.transactionMapper::toDto);

        return APIResponse.newSuccessPageResponse(transactionDTOPage);
    }

    @PostMapping("/transactions")
    public APIResponse<TransactionDTO> createTransaction(@RequestBody @Valid Transaction transaction) {
        Transaction newTransaction = transactionService.createTransaction(transaction);

        return APIResponse.newSuccessResponse(this.transactionMapper.toDto(newTransaction));
    }

    @PutMapping("/transactions")
    public APIResponse<TransactionDTO> updateTransaction(@RequestBody @Valid Transaction transaction) throws ResourceNotFoundException {
        Transaction newTransaction = transactionService.updateTransaction(transaction);

        return APIResponse.newSuccessResponse(this.transactionMapper.toDto(newTransaction));
    }

    @DeleteMapping("/transactions/{id}")
    public APIResponse<Void> deleteTransaction(@PathVariable @Valid String id) throws ResourceNotFoundException {
        transactionService.deleteTransaction(id);

        return APIResponse.newSuccessResponse();
    }
}