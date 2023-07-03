package com.example.sample_analytics.repository;

import com.example.sample_analytics.dto.filter.TransactionFilter;
import com.example.sample_analytics.entity.Transaction;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Collation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.util.Locale.ENGLISH;

public class CustomizedTransactionRepositoryImpl implements CustomizedTransactionRepository {
    private final MongoTemplate mongoTemplate;

    public CustomizedTransactionRepositoryImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public List<Transaction> getTransactionList(TransactionFilter filter) {
        Query query = buildTransactionFilterQuery(filter);

        return this.mongoTemplate.find(query, Transaction.class);
    }

    private Query buildTransactionFilterQuery(TransactionFilter filter) {
        Query query = new Query();
        query.collation(Collation.of(ENGLISH).strength(Collation.ComparisonLevel.secondary()));

        if (filter == null) {
            return query;
        }

        List<Criteria> criteriaList = new ArrayList<>();
        Integer transaction_count = filter.getTransaction_count();

        if (!Objects.isNull(transaction_count)) {
            criteriaList.add(Criteria.where("transaction_count").is(transaction_count));
        }

        if (!CollectionUtils.isEmpty(criteriaList)) {
            query.addCriteria(new Criteria().andOperator(criteriaList.toArray(new Criteria[0])));
        }

        return query;
    }
}
