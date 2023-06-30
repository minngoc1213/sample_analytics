package com.example.sample_analytics.service;

import com.example.sample_analytics.dto.filter.TransactionFilter;
import com.example.sample_analytics.entity.Transaction;
import com.example.sample_analytics.exception.ResourceNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
public interface TransactionService {

    Transaction getTransactionById(String id) throws ResourceNotFoundException;

    Page<Transaction> getTransactionList(TransactionFilter filter, Pageable pageable) throws ResourceNotFoundException;

    Transaction createTransaction(Transaction transaction);

    Transaction updateTransaction(Transaction transaction) throws ResourceNotFoundException;

}
