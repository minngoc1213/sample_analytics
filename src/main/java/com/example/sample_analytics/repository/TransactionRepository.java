package com.example.sample_analytics.repository;

import com.example.sample_analytics.entity.Transaction;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends MongoRepository<Transaction, String>, CustomizedTransactionRepository {

}
