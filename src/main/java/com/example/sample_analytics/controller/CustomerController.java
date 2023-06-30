//package com.example.sample_analytics.controller;
//
//import com.example.sample_analytics.dto.filter.CustomerFilter;
//import com.example.sample_analytics.entity.Customer;
//import com.example.sample_analytics.exception.ResourceNotFoundException;
//import com.example.sample_analytics.service.CustomerService;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//public class CustomerController {
//
//    private final CustomerService customerService;
//
//    public CustomerController(CustomerService customerService) {
//        this.customerService = customerService;
//    }
//
//    @GetMapping("/customers/{id}")
//    public ResponseEntity<?> getCustomerById(@PathVariable String id) throws ResourceNotFoundException {
//        Customer customer = customerService.getCustomerById(id);
//
//        return new ResponseEntity<>(customer, HttpStatus.OK);
//    }
//
//    @GetMapping("/customers")
//    public ResponseEntity<?> getCustomerList(CustomerFilter filter, Pageable pageable) throws ResourceNotFoundException {
//        Page<Customer> customerPage = customerService.getCustomerList(filter, pageable);
//
//        return new ResponseEntity<>(customerPage, HttpStatus.OK);
//    }
//
//    @PostMapping("/customers")
//    public ResponseEntity<?> createCustomer(@RequestBody Customer customer) {
//        Customer newCustomer = customerService.createCustomer(customer);
//
//        return new ResponseEntity<>(newCustomer, HttpStatus.CREATED);
//    }
//
//    @PutMapping("/customers/{id}")
//    public ResponseEntity<?> updateCustomer(@RequestBody Customer customer, @PathVariable String id) {
//        Customer newCustomer = customerService.updateCustomer(customer);
//
//        return new ResponseEntity<>(newCustomer, HttpStatus.OK);
//    }
//
//}
