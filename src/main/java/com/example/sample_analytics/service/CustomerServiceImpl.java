package com.example.sample_analytics.service;

import com.example.sample_analytics.common.exception.ResourceNotFoundException;
import com.example.sample_analytics.dto.filter.CustomerFilter;
import com.example.sample_analytics.dto.mapper.CustomerMapper;
import com.example.sample_analytics.entity.Account;
import com.example.sample_analytics.entity.Customer;
import com.example.sample_analytics.repository.AccountRepository;
import com.example.sample_analytics.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerMapper customerMapper;

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Customer getCustomerById(String id) throws ResourceNotFoundException {
        Customer customer = customerRepository.findById(id).orElse(null);
        if (customer == null) {
            throw new ResourceNotFoundException("Customer not found!");
        }

        return customer;
    }

    @Override
    public List<Customer> getCustomerList(CustomerFilter filter) throws ResourceNotFoundException {
        return customerRepository.getCustomerList(filter);
    }

    @Override
    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        Customer currentCustomer = customerRepository.findById(customer.getId()).orElse(null);
        if (currentCustomer == null) {
            throw new ResourceNotFoundException("Customer not found!");
        }

        return customerRepository.save(customer);
    }

    @Override
    public List<Account> getAccountsByCustomerId(String id) throws ResourceNotFoundException {
        Customer customer = customerRepository.findById(id).orElse(null);
        if (customer == null) {
            throw new ResourceNotFoundException("Customer not found!");
        }

        return accountRepository.getAccountsBySetIds(customer.getAccounts());
    }

}
