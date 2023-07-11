package com.example.sample_analytics.service;

import com.example.sample_analytics.common.exception.ResourceNotFoundException;
import com.example.sample_analytics.dto.filter.AccountFilter;
import com.example.sample_analytics.entity.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
public interface AccountService {
    Account getAccountById(String id) throws ResourceNotFoundException;

    Page<Account> getAccountList(AccountFilter filter, Pageable pageable);

    Account createAccount(Account account);

    Account updateAccount(Account account) throws ResourceNotFoundException;

    void deleteAccount(String id) throws ResourceNotFoundException;

}
