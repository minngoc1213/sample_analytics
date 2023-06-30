package com.example.sample_analytics.service;

import com.example.sample_analytics.dto.filter.TransactionFilter;
import com.example.sample_analytics.entity.Transaction;
import com.example.sample_analytics.exception.ResourceNotFoundException;
import com.example.sample_analytics.repository.TransactionRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;

    public TransactionServiceImpl(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public Transaction getTransactionById(String id) throws ResourceNotFoundException {
        Transaction transaction = transactionRepository.findById(id).orElse(null);
        if (transaction == null) {
            throw new ResourceNotFoundException("Transaction not found!");
        }

        return transaction;
    }

    @Override
    public Page<Transaction> getTransactionList(TransactionFilter filter, Pageable pageable) throws ResourceNotFoundException {
        return transactionRepository.getTransactionList(filter, pageable);
    }

    @Override
    public Transaction createTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    @Override
    public Transaction updateTransaction(Transaction transaction) throws ResourceNotFoundException {
        Transaction currentTransaction = transactionRepository.findById(transaction.getId()).orElse(null);
        if (currentTransaction == null) {
            throw new ResourceNotFoundException("Transaction not found!");
        }

        return transactionRepository.save(transaction);
    }

}
