//package com.example.sample_analytics.controller;
//
//import com.example.sample_analytics.dto.filter.AccountFilter;
//import com.example.sample_analytics.entity.Account;
//import com.example.sample_analytics.exception.ResourceNotFoundException;
//import com.example.sample_analytics.service.AccountService;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//public class AccountController {
//
//    private final AccountService accountService;
//
//    public AccountController(AccountService accountService) {
//        this.accountService = accountService;
//    }
//
//    @GetMapping("/accounts/{id}")
//    public ResponseEntity<?> getAccountById(@PathVariable String id) throws ResourceNotFoundException {
//        Account account = accountService.getAccountById(id);
//
//        return new ResponseEntity<>(account, HttpStatus.OK);
//    }
//
//    @GetMapping("/accounts")
//    public ResponseEntity<?> getAccountList(AccountFilter filter, Pageable pageable) throws ResourceNotFoundException {
//        Page<Account> accountPage = accountService.getAccountList(filter, pageable);
//
//        return new ResponseEntity<>(accountPage, HttpStatus.OK);
//    }
//
//    @PostMapping("/accounts")
//    public ResponseEntity<?> createAccount(@RequestBody Account account) {
//        Account newAccount = accountService.createAccount(account);
//
//        return new ResponseEntity<>(newAccount, HttpStatus.CREATED);
//    }
//
//    @PutMapping("/accounts/{id}")
//    public ResponseEntity<?> updateAccount(@RequestBody Account account, @PathVariable String id) {
//        Account newAccount = accountService.updateAccount(account);
//
//        return new ResponseEntity<>(newAccount, HttpStatus.OK);
//    }
//
//}
