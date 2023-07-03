package com.example.sample_analytics.service;

import com.example.sample_analytics.common.exception.ResourceNotFoundException;
import com.example.sample_analytics.dto.filter.AccountFilter;
import com.example.sample_analytics.entity.Account;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface AccountService {
    Account getAccountById(String id) throws ResourceNotFoundException;

    List<Account> getAccountList(AccountFilter filter) throws ResourceNotFoundException;

    Account createAccount(Account account);

    Account updateAccount(Account account) throws ResourceNotFoundException;

}
