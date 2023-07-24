package com.example.sample_analytics.user.repository;

import com.example.sample_analytics.user.dto.filter.AccountFilter;
import com.example.sample_analytics.user.entity.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CustomizedAccountRepository {
    Page<Account> getAccountList(AccountFilter filter, Pageable pageable);

}
