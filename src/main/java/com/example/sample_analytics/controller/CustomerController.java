package com.example.sample_analytics.controller;

import com.example.sample_analytics.common.exception.ResourceNotFoundException;
import com.example.sample_analytics.dto.CustomerDTO;
import com.example.sample_analytics.dto.filter.CustomerFilter;
import com.example.sample_analytics.dto.mapper.CustomerMapper;
import com.example.sample_analytics.entity.Account;
import com.example.sample_analytics.entity.Customer;
import com.example.sample_analytics.service.CustomerService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {
    private final CustomerService customerService;

    private final CustomerMapper customerMapper;

    public CustomerController(CustomerService customerService, CustomerMapper customerMapper) {
        this.customerService = customerService;
        this.customerMapper = customerMapper;
    }

    @GetMapping("/customers/{id}")
    public ResponseEntity<?> getCustomerById(@PathVariable String id) throws ResourceNotFoundException {
        Customer customer = customerService.getCustomerById(id);

        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @GetMapping("/customers")
    public ResponseEntity<?> getCustomerList(CustomerFilter filter, Pageable pageable) throws ResourceNotFoundException {
        List<Customer> customerList = customerService.getCustomerList(filter);
        Page<CustomerDTO> customerDTOPage = new PageImpl<>(customerMapper.toDto(customerList), pageable, customerList.size());

        return new ResponseEntity<>(customerDTOPage, HttpStatus.OK);
    }

    @PostMapping("/customers")
    public ResponseEntity<?> createCustomer(@RequestBody Customer customer) {
        Customer newCustomer = customerService.createCustomer(customer);

        return new ResponseEntity<>(newCustomer, HttpStatus.CREATED);
    }

    @PutMapping("/customers/{id}")
    public ResponseEntity<?> updateCustomer(@RequestBody Customer customer, @PathVariable String id) {
        Customer newCustomer = customerService.updateCustomer(customer);

        return new ResponseEntity<>(newCustomer, HttpStatus.OK);
    }

    @GetMapping("/customers/{id}/accounts")
    public ResponseEntity<?> getAccountsByCustomerId(@PathVariable String id, Pageable pageable) {
        List<Account> accountList = customerService.getAccountsByCustomerId(id);
        Page<Account> accountPage = new PageImpl<>(accountList, pageable, accountList.size());

        return new ResponseEntity<>(accountPage, HttpStatus.OK);
    }

}
