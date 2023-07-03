package com.example.sample_analytics.service;

import com.example.sample_analytics.dto.TransactionDTO;
import com.example.sample_analytics.dto.filter.TransactionFilter;
import com.example.sample_analytics.entity.Transaction;
import com.example.sample_analytics.common.exception.ResourceNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface TransactionService {

    Transaction getTransactionById(String id) throws ResourceNotFoundException;

    List<Transaction> getTransactionList(TransactionFilter filter) throws ResourceNotFoundException;

    Transaction createTransaction(Transaction transaction);

    Transaction updateTransaction(Transaction transaction) throws ResourceNotFoundException;

}
