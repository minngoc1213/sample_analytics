package com.example.sample_analytics.entity;

import jakarta.validation.constraints.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import static com.example.sample_analytics.common.constant.Constant.ID_REGEX;
import static com.example.sample_analytics.common.constant.Constant.STRING_MAX_LENGTH;

@Document(collection = "transactions")
public class Transaction {
    @Id
    @Pattern(regexp = ID_REGEX)
    private String id;

    @NotNull
    @Positive
    private Integer account_id;

    @PositiveOrZero
    private Integer transaction_count;

    private Date bucket_start_date;

    private Date bucket_end_date;

    private Set<Transactions> transactions = new HashSet<>();

    public static class Transactions {
        @NotNull
        @Past
        private Date date;

        @NotNull
        @Positive
        private Integer amount;

        @NotNull
        @Size(max = STRING_MAX_LENGTH)
        private String transaction_code;

        @Size(max = STRING_MAX_LENGTH)
        private String symbol;

        @NotNull
        @Positive
        private Double price;

        @NotNull
        @Positive
        private Double total;

        public Transactions(@NotNull Date date, @NotNull Integer amount, @NotNull String transaction_code, String symbol, @NotNull Double price, @NotNull Double total) {
            this.date = date;
            this.amount = amount;
            this.transaction_code = transaction_code;
            this.symbol = symbol;
            this.price = price;
            this.total = total;
        }

        public Date getDate() {
            return date;
        }

        public void setDate(Date date) {
            this.date = date;
        }

        public Integer getAmount() {
            return amount;
        }

        public void setAmount(Integer amount) {
            this.amount = amount;
        }

        public String getTransaction_code() {
            return transaction_code;
        }

        public void setTransaction_code(String transaction_code) {
            this.transaction_code = transaction_code;
        }

        public String getSymbol() {
            return symbol;
        }

        public void setSymbol(String symbol) {
            this.symbol = symbol;
        }

        public Double getPrice() {
            return price;
        }

        public void setPrice(Double price) {
            this.price = price;
        }

        public Double getTotal() {
            return total;
        }

        public void setTotal(Double total) {
            this.total = total;
        }
    }

    public Transaction(String id, @NotNull Integer account_id, @NotNull Integer transaction_count, Date bucket_start_date, Date bucket_end_date, Set<Transactions> transactions) {
        this.id = id;
        this.account_id = account_id;
        this.transaction_count = transaction_count;
        this.bucket_start_date = bucket_start_date;
        this.bucket_end_date = bucket_end_date;
        this.transactions = transactions;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getAccount_id() {
        return account_id;
    }

    public void setAccount_id(Integer account_id) {
        this.account_id = account_id;
    }

    public Integer getTransaction_count() {
        return transaction_count;
    }

    public void setTransaction_count(Integer transaction_count) {
        this.transaction_count = transaction_count;
    }

    public Date getBucket_start_date() {
        return bucket_start_date;
    }

    public void setBucket_start_date(Date bucket_start_date) {
        this.bucket_start_date = bucket_start_date;
    }

    public Date getBucket_end_date() {
        return bucket_end_date;
    }

    public void setBucket_end_date(Date bucket_end_date) {
        this.bucket_end_date = bucket_end_date;
    }

    public Set<Transactions> getTransactions() {
        return transactions;
    }

    public void setTransactions(Set<Transactions> transactions) {
        this.transactions = transactions;
    }
}
