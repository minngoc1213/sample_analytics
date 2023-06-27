package com.example.sample_analytics.controller;

import com.example.sample_analytics.domain.Customer;
import com.example.sample_analytics.repository.CustomerRepository;
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
@RequestMapping("/customers")
@Api(value = "Customer API")
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("")
    @ApiOperation(value = "Get all customers", response = Customer.class)
    public ResponseEntity<?> getAllCustomers(Pageable pageable) {
        Page<Customer> customers = customerRepository.findAll(pageable);

        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get customer by ID", response = Customer.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = Customer.class),
            @ApiResponse(code = 404, message = "Customer not found", response = ErrorResponse.class)
    })
    public ResponseEntity<?> getCustomerById(@PathVariable String id) {
        Optional<Customer> customer = customerRepository.findById(id);

        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @PostMapping("")
    @ApiOperation(value = "Create new customer", response = Void.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Customer created successfully", response = Void.class),
            @ApiResponse(code = 500, message = "Error creating customer", response = ErrorResponse.class)
    })
    public ResponseEntity<?> createCustomer(@RequestBody @Valid Customer customer) {
        customerRepository.save(customer);

        HttpHeaders responseHeaders = new HttpHeaders();

        URI newCustomerUri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(customer.getId())
                .toUri();

        responseHeaders.setLocation(newCustomerUri);

        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Update customer by ID", notes = "If customer not exists, create new customer", response = Void.class)
    public ResponseEntity<?> updateCustomerById(@PathVariable String id, @RequestBody @Valid Customer customer) {
        customerRepository.save(customer);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete customer by id", response = Void.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Customer deleted successfully", response = Void.class),
            @ApiResponse(code = 404, message = "Customer not found", response = ErrorResponse.class)
    })
    public ResponseEntity<?> deleteCustomerById(@PathVariable String id) {
        customerRepository.deleteById(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
