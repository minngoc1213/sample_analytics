package com.example.sample_analytics.dto.filter;

import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.util.HashSet;
import java.util.Set;

import static com.example.sample_analytics.common.constant.Constant.STRING_MAX_LENGTH;

public class AccountFilter {
    @Positive
    private Integer limit = null;

    @Size(max = STRING_MAX_LENGTH)
    private Set<String> products = new HashSet<>();

    public AccountFilter() {

    }

    public AccountFilter(Integer limit, Set<String> products) {
        this.limit = limit;
        this.products = products;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Set<String> getProducts() {
        return products;
    }

    public void setProducts(Set<String> products) {
        this.products = products;
    }
}
