package com.example.sample_analytics.user.entity;

import com.example.sample_analytics.user.entity.validator.DatabaseIdConstraint;
import com.example.sample_analytics.user.entity.validator.DatabaseStringListConstraint;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Document(collection = "accounts")
public class Account {
    @DatabaseIdConstraint
    private String id;

    @NotNull
    @Positive
    @Field(name = "account_id")
    private Integer accountId;

    @Positive
    private Integer limit;

    @DatabaseStringListConstraint
    private Set<String> products = new HashSet<>();

    public Account() {
        accountId = 0;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public @NotNull Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(@NotNull Integer accountId) {
        this.accountId = accountId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Account)) {
            return false;
        }

        return accountId.equals(((Account) o).accountId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
