package com.example.sample_analytics.service;

import com.example.sample_analytics.common.exception.ResourceNotFoundException;
import com.example.sample_analytics.dto.filter.AccountFilter;
import com.example.sample_analytics.entity.Account;
import com.example.sample_analytics.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Account getAccountById(String id) throws ResourceNotFoundException {
        Account account = accountRepository.findById(id).orElse(null);
        if (account == null) {
            throw new ResourceNotFoundException("Account not found!");
        }

        return account;
    }

    @Override
    public List<Account> getAccountList(AccountFilter filter) throws ResourceNotFoundException {
        return accountRepository.getAccountList(filter);
    }

    @Override
    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public Account updateAccount(Account account) throws ResourceNotFoundException {
        Account newAccount = accountRepository.findById(account.getId()).orElse(null);
        if (newAccount == null) {
            throw new ResourceNotFoundException("Account not found!");
        }

        return accountRepository.save(account);
    }

}
