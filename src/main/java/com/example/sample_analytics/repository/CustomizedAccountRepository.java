package com.example.sample_analytics.repository;

import com.example.sample_analytics.dto.filter.AccountFilter;
import com.example.sample_analytics.entity.Account;

import java.util.List;

public interface CustomizedAccountRepository {
    List<Account> getAccountList(AccountFilter filter);

}
