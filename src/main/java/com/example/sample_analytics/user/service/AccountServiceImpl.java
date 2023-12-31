package com.example.sample_analytics.user.service;

import com.example.sample_analytics.common.exception.ResourceNotFoundException;
import com.example.sample_analytics.user.dto.filter.AccountFilter;
import com.example.sample_analytics.user.entity.Account;
import com.example.sample_analytics.user.repository.AccountRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Account getAccountById(String id) throws ResourceNotFoundException {
        Account account = accountRepository.findById(id).orElse(null);
        if (account == null) {
            throw new ResourceNotFoundException("Account not found!");
        }

        return account;
    }

    @Override
    public Page<Account> getAccountList(AccountFilter filter, Pageable pageable) {

        return accountRepository.getAccountList(filter, pageable);
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

    @Override
    public void deleteAccount(String id) throws ResourceNotFoundException {
        Account account = accountRepository.findById(id).orElse(null);
        if (account == null) {
            throw new ResourceNotFoundException("Account not found!");
        }

        accountRepository.deleteById(id);
    }
}
