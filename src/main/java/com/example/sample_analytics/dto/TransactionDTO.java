package com.example.sample_analytics.dto;

import java.util.Date;

public class TransactionDTO {
    private String id;

    private Integer account_id;

    private Integer transaction_count;

    private Date bucket_start_date;

    private Date bucket_end_date;

    public TransactionDTO(String id, Integer account_id, Integer transaction_count, Date bucket_start_date, Date bucket_end_date) {
        this.id = id;
        this.account_id = account_id;
        this.transaction_count = transaction_count;
        this.bucket_start_date = bucket_start_date;
        this.bucket_end_date = bucket_end_date;
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
}
