package com.example.sample_analytics.repository;

import com.example.sample_analytics.dto.filter.AccountFilter;
import com.example.sample_analytics.entity.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Collation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import static java.util.Locale.ENGLISH;

public class CustomizedAccountRepositoryImpl implements CustomizedAccountRepository {
    private final MongoTemplate mongoTemplate;

    public CustomizedAccountRepositoryImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public Page<Account> getAccountList(AccountFilter filter, Pageable pageable) {
        Query query = buildAccountFilterQuery(filter);
        query.with(pageable);

        return PageableExecutionUtils.getPage(
                this.mongoTemplate.find(query, Account.class),
                pageable,
                () -> this.mongoTemplate.count(query.skip(0).limit(0), Account.class)
        );
    }

    private Query buildAccountFilterQuery(AccountFilter filter) {
        Query query = new Query();
        query.collation(Collation.of(ENGLISH).strength(Collation.ComparisonLevel.secondary()));

        if (filter == null) {
            return query;
        }

        List<Criteria> criteriaList = new ArrayList<>();

        Integer limit = filter.getLimit();
        Set<String> products = filter.getProducts();

        if (!Objects.isNull(limit)) {
            criteriaList.add(Criteria.where("limit").is(limit));
        }

        if (!CollectionUtils.isEmpty(products)) {
            criteriaList.add(Criteria.where("products").in(products));
        }

        if (!CollectionUtils.isEmpty(criteriaList)) {
            query.addCriteria(new Criteria().andOperator(criteriaList.toArray(new Criteria[0])));
        }

        return query;
    }
}
