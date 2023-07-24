package com.example.sample_analytics.web.controller;

import com.example.sample_analytics.common.exception.ResourceNotFoundException;
import com.example.sample_analytics.user.dto.CustomerDTO;
import com.example.sample_analytics.user.dto.filter.CustomerFilter;
import com.example.sample_analytics.user.dto.mapper.CustomerMapper;
import com.example.sample_analytics.user.entity.Account;
import com.example.sample_analytics.user.entity.Customer;
import com.example.sample_analytics.user.service.CustomerService;
import com.example.sample_analytics.web.response.APIResponse;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public APIResponse<CustomerDTO> getCustomerById(@PathVariable @Valid String id) throws ResourceNotFoundException {
        Customer customer = customerService.getCustomerById(id);

        return APIResponse.newSuccessResponse(this.customerMapper.toDto(customer));
    }

    @GetMapping("/customers")
    public APIResponse<List<CustomerDTO>> getCustomerList(CustomerFilter filter, Pageable pageable) {
        Page<Customer> customerPage = customerService.getCustomerList(filter, pageable);
        Page<CustomerDTO> customerDTOPage = customerPage.map(this.customerMapper::toDto);

        return APIResponse.newSuccessPageResponse(customerDTOPage);
    }

    @PostMapping("/customers")
    public APIResponse<CustomerDTO> createCustomer(@RequestBody @Valid Customer customer) {
        Customer newCustomer = customerService.createCustomer(customer);

        return APIResponse.newSuccessResponse(this.customerMapper.toDto(newCustomer));
    }

    @PutMapping("/customers")
    public APIResponse<CustomerDTO> updateCustomer(@RequestBody @Valid Customer customer) throws ResourceNotFoundException {
        Customer newCustomer = customerService.updateCustomer(customer);

        return APIResponse.newSuccessResponse(this.customerMapper.toDto(newCustomer));
    }

    @DeleteMapping("/customers/{id}")
    public APIResponse<Void> deleteCustomer(@PathVariable @Valid String id) throws ResourceNotFoundException {
        customerService.deleteCustomer(id);

        return APIResponse.newSuccessResponse();
    }

    @GetMapping("/customers/{id}/accounts")
    public APIResponse<List<Account>> getAccountsByCustomerId(@PathVariable @Valid String id, Pageable pageable) throws ResourceNotFoundException {
        Page<Account> accountPage = customerService.getAccountsByCustomerId(id, pageable);

        return APIResponse.newSuccessPageResponse(accountPage);
    }

}
