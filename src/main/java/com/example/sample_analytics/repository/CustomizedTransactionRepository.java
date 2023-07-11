package com.example.sample_analytics.repository;

import com.example.sample_analytics.dto.filter.TransactionFilter;
import com.example.sample_analytics.entity.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CustomizedTransactionRepository {
    Page<Transaction> getTransactionList(TransactionFilter filter, Pageable pageable);

}
