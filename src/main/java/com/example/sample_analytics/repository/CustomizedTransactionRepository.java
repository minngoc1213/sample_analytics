package com.example.sample_analytics.repository;

import com.example.sample_analytics.dto.filter.TransactionFilter;
import com.example.sample_analytics.entity.Transaction;

import java.util.List;

public interface CustomizedTransactionRepository {
    List<Transaction> getTransactionList(TransactionFilter filter);

}
