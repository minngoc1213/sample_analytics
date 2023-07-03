package com.example.sample_analytics.dto.filter;

public class TransactionFilter {
    private Integer transaction_count = null;

    public TransactionFilter() {

    }

    public TransactionFilter(Integer transaction_count) {
        this.transaction_count = transaction_count;
    }

    public Integer getTransaction_count() {
        return transaction_count;
    }

    public void setTransaction_count(Integer transaction_count) {
        this.transaction_count = transaction_count;
    }
}
