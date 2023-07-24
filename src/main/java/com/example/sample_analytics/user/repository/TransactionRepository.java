package com.example.sample_analytics.user.repository;

import com.example.sample_analytics.user.entity.Transaction;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends MongoRepository<Transaction, String>, CustomizedTransactionRepository {

}
