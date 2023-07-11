package com.example.sample_analytics.dto;

import java.util.Date;

public class TransactionDTO {
    private String id;

    private Integer accountId;

    private Integer transactionCount;

    private Date bucketStartDate;

    private Date bucketEndDate;

    public TransactionDTO() {
    }

    public TransactionDTO(String id, Integer accountId, Integer transactionCount, Date bucketStartDate, Date bucketEndDate) {
        this.id = id;
        this.accountId = accountId;
        this.transactionCount = transactionCount;
        this.bucketStartDate = bucketStartDate;
        this.bucketEndDate = bucketEndDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
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
}
