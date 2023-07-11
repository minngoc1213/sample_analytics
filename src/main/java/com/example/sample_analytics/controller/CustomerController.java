package com.example.sample_analytics.controller;

import com.example.sample_analytics.common.exception.ResourceNotFoundException;
import com.example.sample_analytics.dto.CustomerDTO;
import com.example.sample_analytics.dto.filter.CustomerFilter;
import com.example.sample_analytics.dto.mapper.CustomerMapper;
import com.example.sample_analytics.entity.Account;
import com.example.sample_analytics.entity.Customer;
import com.example.sample_analytics.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
public class CustomerController {
    private final CustomerService customerService;

    private final CustomerMapper customerMapper;

    public CustomerController(CustomerService customerService, CustomerMapper customerMapper) {
        this.customerService = customerService;
        this.customerMapper = customerMapper;
    }

    @GetMapping("/customers/{id}")
    public ResponseEntity<?> getCustomerById(@PathVariable @Valid String id) throws ResourceNotFoundException {
        Customer customer = customerService.getCustomerById(id);

        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @GetMapping("/customers")
    public ResponseEntity<?> getCustomerList(CustomerFilter filter, Pageable pageable) {
        Page<Customer> customerPage = customerService.getCustomerList(filter, pageable);
        Page<CustomerDTO> customerDTOPage = customerPage.map(this.customerMapper::toDto);

        return new ResponseEntity<>(customerDTOPage, HttpStatus.OK);
    }

    @PostMapping("/customers")
    public ResponseEntity<?> createCustomer(@RequestBody @Valid Customer customer) {
        Customer newCustomer = customerService.createCustomer(customer);

        return new ResponseEntity<>(newCustomer, HttpStatus.CREATED);
    }

    @PutMapping("/customers")
    public ResponseEntity<?> updateCustomer(@RequestBody @Valid Customer customer) throws ResourceNotFoundException {
        Customer newCustomer = customerService.updateCustomer(customer);

        return new ResponseEntity<>(newCustomer, HttpStatus.OK);
    }

    @DeleteMapping("/customers/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable @Valid String id) throws ResourceNotFoundException {
        customerService.deleteCustomer(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/customers/{id}/accounts")
    public ResponseEntity<?> getAccountsByCustomerId(@PathVariable @Valid String id, Pageable pageable) throws ResourceNotFoundException {
        Page<Account> accountPage = customerService.getAccountsByCustomerId(id, pageable);

        return new ResponseEntity<>(accountPage, HttpStatus.OK);
    }

}
