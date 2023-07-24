package com.example.sample_analytics.user.dto.filter;

import java.util.HashSet;
import java.util.Set;

public class AccountFilter {
    private Integer limit = null;

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
