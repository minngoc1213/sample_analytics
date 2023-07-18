package com.example.sample_analytics.user.entity;

import com.example.sample_analytics.user.entity.validator.DatabaseIdConstraint;
import jakarta.validation.constraints.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import static com.example.sample_analytics.common.constant.Constant.STRING_MAX_LENGTH;

@Document(collection = "transactions")
public class Transaction {
    @DatabaseIdConstraint
    private String id;

    @NotNull
    @Positive
    @Field(name = "account_id")
    private Integer accountId;

    @PositiveOrZero
    @Field(name = "transaction_count")
    private Integer transactionCount;

    @Field(name = "bucket_start_date")
    private Date bucketStartDate;

    @Field(name = "bucket_end_date")
    private Date bucketEndDate;

    private Set<Transactions> transactions = new HashSet<>();

    public Transaction() {
        accountId = 0;
    }

    public static class Transactions {
        @NotNull
        @Past
        private Date date;

        @NotNull
        @Positive
        private Integer amount;

        @NotBlank
        @Size(max = STRING_MAX_LENGTH)
        @Field(name = "transaction_code")
        private String transactionCode;

        @Size(max = STRING_MAX_LENGTH)
        private String symbol;

        @NotNull
        @Positive
        private Double price;

        @NotNull
        @Positive
        private Double total;

        public Transactions() {
            date = new Date();
            amount = 0;
            total = 0.0;
            price = 0.0;
        }

        public @NotNull Date getDate() {
            return date;
        }

        public void setDate(@NotNull Date date) {
            this.date = date;
        }

        public @NotNull Integer getAmount() {
            return amount;
        }

        public void setAmount(@NotNull Integer amount) {
            this.amount = amount;
        }

        public String getTransactionCode() {
            return transactionCode;
        }

        public void setTransactionCode(String transactionCode) {
            this.transactionCode = transactionCode;
        }

        public String getSymbol() {
            return symbol;
        }

        public void setSymbol(String symbol) {
            this.symbol = symbol;
        }

        public @NotNull Double getPrice() {
            return price;
        }

        public void setPrice(@NotNull Double price) {
            this.price = price;
        }

        public @NotNull Double getTotal() {
            return total;
        }

        public void setTotal(@NotNull Double total) {
            this.total = total;
        }
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

    public Integer getTransactionCount() {
        return transactionCount;
    }

    public void setTransactionCount(Integer transactionCount) {
        this.transactionCount = transactionCount;
    }

    public Date getBucketStartDate() {
        return bucketStartDate;
    }

    public void setBucketStartDate(Date bucketStartDate) {
        this.bucketStartDate = bucketStartDate;
    }

    public Date getBucketEndDate() {
        return bucketEndDate;
    }

    public void setBucketEndDate(Date bucketEndDate) {
        this.bucketEndDate = bucketEndDate;
    }

    public Set<Transactions> getTransactions() {
        return transactions;
    }

    public void setTransactions(Set<Transactions> transactions) {
        this.transactions = transactions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Transaction)) {
            return false;
        }

        return accountId.equals(((Transaction) o).accountId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(accountId);
    }
}
