package com.example.sample_analytics.user.service;

import com.example.sample_analytics.common.exception.ResourceNotFoundException;
import com.example.sample_analytics.user.dto.filter.CustomerFilter;
import com.example.sample_analytics.user.entity.Account;
import com.example.sample_analytics.user.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
public interface CustomerService {
    Customer getCustomerById(String id) throws ResourceNotFoundException;

    Page<Customer> getCustomerList(CustomerFilter filter, Pageable pageable);

    Customer createCustomer(Customer customer);

    Customer updateCustomer(Customer customer) throws ResourceNotFoundException;

    void deleteCustomer(String id) throws ResourceNotFoundException;

    Page<Account> getAccountsByCustomerId(String id, Pageable pageable) throws ResourceNotFoundException;

}
