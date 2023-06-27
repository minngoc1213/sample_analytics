package com.example.sample_analytics.controller;

import com.example.sample_analytics.domain.Account;
import com.example.sample_analytics.repository.AccountRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/accounts")
@Api(value = "Account API")
public class AccountController {
    @Autowired
    private AccountRepository accountRepository;

    @GetMapping("")
    @ApiOperation(value = "Get all accounts", response = Account.class)
    public ResponseEntity<?> getAllAccounts(Pageable pageable) {
        Page<Account> accounts = accountRepository.findAll(pageable);

        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get account by ID", response = Account.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = Account.class),
            @ApiResponse(code = 404, message = "Account not found", response = ErrorResponse.class)
    })
    public ResponseEntity<?> getAccountById(@PathVariable String id) {
        Optional<Account> account = accountRepository.findById(id);

        return new ResponseEntity<>(account, HttpStatus.OK);
    }

    @PostMapping("")
    @ApiOperation(value = "Create new account", response = Void.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Account created successfully", response = Void.class),
            @ApiResponse(code = 500, message = "Error creating account", response = ErrorResponse.class)
    })
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

    @PutMapping("/{id}")
    @ApiOperation(value = "Update account by ID", notes = "If account not exists, create new account", response = Void.class)
    public ResponseEntity<?> updateAccountById(@PathVariable String id, @RequestBody @Valid Account account) {
        accountRepository.save(account);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete account by ID", response = Void.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Account deleted successfully", response = void.class),
            @ApiResponse(code = 404, message = "Account not found", response = ErrorResponse.class)
    })
    public ResponseEntity<?> deleteAccountById(@PathVariable String id) {
        accountRepository.deleteById(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
