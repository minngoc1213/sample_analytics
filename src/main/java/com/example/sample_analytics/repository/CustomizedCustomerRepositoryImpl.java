package com.example.sample_analytics.repository;

import com.example.sample_analytics.common.utils.QueryUtils;
import com.example.sample_analytics.dto.filter.CustomerFilter;
import com.example.sample_analytics.entity.Customer;
import org.apache.commons.lang3.StringUtils;
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
import java.util.regex.Pattern;

import static java.util.Locale.ENGLISH;

public class CustomizedCustomerRepositoryImpl implements CustomizedCustomerRepository {
    private final MongoTemplate mongoTemplate;

    public CustomizedCustomerRepositoryImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public Page<Customer> getCustomerList(CustomerFilter filter, Pageable pageable) {
        Query query = buildCustomerFilterQuery(filter);
        query.with(pageable);

        return PageableExecutionUtils.getPage(
                this.mongoTemplate.find(query, Customer.class),
                pageable,
                () -> this.mongoTemplate.count(query.skip(0).limit(0), Customer.class)
        );
    }

    private Query buildCustomerFilterQuery(CustomerFilter filter) {
        Query query = new Query();
        query.collation(Collation.of(ENGLISH).strength(Collation.ComparisonLevel.secondary()));

        if (filter == null) {
            return query;
        }

        List<Criteria> criteriaList = new ArrayList<>();
        String name = filter.getName();
        String address = filter.getAddress();
        String active = filter.getActive();

        if (StringUtils.isNotBlank(name)) {
            name = Pattern.quote(name);
            criteriaList.add(Criteria.where("name").regex(name, "i"));
        }

        if (StringUtils.isNotBlank(address)) {
            address = Pattern.quote(address);
            criteriaList.add(Criteria.where("address").regex(address, "i"));
        }

        QueryUtils.buildBooleanFilterCriteriaList(criteriaList, "active", active);

        if (!CollectionUtils.isEmpty(criteriaList)) {
            query.addCriteria(new Criteria().andOperator(criteriaList.toArray(new Criteria[0])));
        }

        return query;
    }
}
