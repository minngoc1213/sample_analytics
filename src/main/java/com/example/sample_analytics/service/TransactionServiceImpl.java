package com.example.sample_analytics.service;

import com.example.sample_analytics.common.exception.ResourceNotFoundException;
import com.example.sample_analytics.dto.filter.TransactionFilter;
import com.example.sample_analytics.dto.mapper.TransactionMapper;
import com.example.sample_analytics.entity.Transaction;
import com.example.sample_analytics.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public List<Transaction> getTransactionList(TransactionFilter filter) throws ResourceNotFoundException {
        return transactionRepository.getTransactionList(filter);
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
