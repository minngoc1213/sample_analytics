package com.example.sample_analytics.controller;

import com.example.sample_analytics.domain.Account;
import com.example.sample_analytics.repository.AccountRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
public class AccountController {
    @Autowired
    private AccountRepository accountRepository;

    // Return all accounts
    @GetMapping("/accounts")
    public ResponseEntity<?> getAllPosts(Pageable pageable) {
        Page<Account> accounts = accountRepository.findAll(pageable);

        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }

    // Return an account by id
    @GetMapping("/accounts/{id}")
    public ResponseEntity<?> getAccountById(@PathVariable String id) {
        Optional<Account> account = accountRepository.findById(id);

        return new ResponseEntity<>(account, HttpStatus.OK);
    }

    // Create a transaction
    @PostMapping("/accounts")
    public ResponseEntity<?> createAccount(@RequestBody @Valid Account account) {
        accountRepository.save(account);

        HttpHeaders responseHeaders = new HttpHeaders();

        URI newAccountUri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(account.getId())
                .toUri();

        responseHeaders.setLocation(newAccountUri);

        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }

    // Update an account by id
    @PutMapping("/accounts/{id}")
    public ResponseEntity<?> updateAccountById(@PathVariable String id, @RequestBody @Valid Account account) {
        accountRepository.save(account);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    // Delete an account by id
    @DeleteMapping("/accounts/{id}")
    public ResponseEntity<?> deleteAccountById(@PathVariable String id) {
        accountRepository.deleteById(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
