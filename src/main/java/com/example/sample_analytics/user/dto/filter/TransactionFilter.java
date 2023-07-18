package com.example.sample_analytics.user.dto.filter;

public class TransactionFilter {
    private Integer transactionCount = null;

    public TransactionFilter() {
    }

    public TransactionFilter(Integer transactionCount) {
        this.transactionCount = transactionCount;
    }

    public Integer getTransactionCount() {
        return transactionCount;
    }

    public void setTransactionCount(Integer transactionCount) {
        this.transactionCount = transactionCount;
    }
}
