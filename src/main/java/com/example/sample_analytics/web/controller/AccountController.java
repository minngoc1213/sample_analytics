package com.example.sample_analytics.web.controller;

import com.example.sample_analytics.common.exception.ResourceNotFoundException;
import com.example.sample_analytics.user.dto.filter.AccountFilter;
import com.example.sample_analytics.user.entity.Account;
import com.example.sample_analytics.user.service.AccountService;
import com.example.sample_analytics.web.response.APIResponse;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
public class AccountController {
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/accounts/{id}")
    public APIResponse<Account> getAccountById(@PathVariable @Valid String id) throws ResourceNotFoundException {
        Account account = accountService.getAccountById(id);

        return APIResponse.newSuccessResponse(account);
    }

    @GetMapping("/accounts")
    public APIResponse<List<Account>> getAccountList(AccountFilter filter, Pageable pageable) {
        Page<Account> accountPage = accountService.getAccountList(filter, pageable);

        return APIResponse.newSuccessPageResponse(accountPage);
    }

    @PostMapping("/accounts")
    public APIResponse<Account> createAccount(@RequestBody @Valid Account account) {
        Account newAccount = accountService.createAccount(account);

        return APIResponse.newSuccessResponse(newAccount);
    }

    @PutMapping("/accounts")
    public APIResponse<Account> updateAccount(@RequestBody @Valid Account account) throws ResourceNotFoundException {
        Account newAccount = accountService.updateAccount(account);

        return APIResponse.newSuccessResponse(newAccount);
    }

    @DeleteMapping("/accounts/{id}")
    public APIResponse<Void> deleteAccount(@PathVariable @Valid String id) throws ResourceNotFoundException {
        accountService.deleteAccount(id);

        return APIResponse.newSuccessResponse();
    }

}
