package com.example.sample_analytics.controller;

import com.example.sample_analytics.common.exception.ResourceNotFoundException;
import com.example.sample_analytics.dto.filter.AccountFilter;
import com.example.sample_analytics.entity.Account;
import com.example.sample_analytics.service.AccountService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
public class AccountController {
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/accounts/{id}")
    public ResponseEntity<?> getAccountById(@PathVariable @Valid String id) throws ResourceNotFoundException {
        Account account = accountService.getAccountById(id);

        return new ResponseEntity<>(account, HttpStatus.OK);
    }

    @GetMapping("/accounts")
    public ResponseEntity<?> getAccountList(AccountFilter filter, Pageable pageable) {
        Page<Account> accountPage = accountService.getAccountList(filter, pageable);

        return new ResponseEntity<>(accountPage, HttpStatus.OK);
    }

    @PostMapping("/accounts")
    public ResponseEntity<?> createAccount(@RequestBody @Valid Account account) {
        Account newAccount = accountService.createAccount(account);

        return new ResponseEntity<>(newAccount, HttpStatus.CREATED);
    }

    @PutMapping("/accounts")
    public ResponseEntity<?> updateAccount(@RequestBody @Valid Account account) throws ResourceNotFoundException {
        Account newAccount = accountService.updateAccount(account);

        return new ResponseEntity<>(newAccount, HttpStatus.OK);
    }

    @DeleteMapping("/accounts/{id}")
    public ResponseEntity<?> deleteAccount(@PathVariable @Valid String id) throws ResourceNotFoundException {
        accountService.deleteAccount(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
