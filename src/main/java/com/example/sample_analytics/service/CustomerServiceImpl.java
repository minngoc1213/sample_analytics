package com.example.sample_analytics.service;

import com.example.sample_analytics.common.exception.ResourceNotFoundException;
import com.example.sample_analytics.dto.filter.CustomerFilter;
import com.example.sample_analytics.entity.Account;
import com.example.sample_analytics.entity.Customer;
import com.example.sample_analytics.repository.AccountRepository;
import com.example.sample_analytics.repository.CustomerRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    private final AccountRepository accountRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository, AccountRepository accountRepository) {
        this.customerRepository = customerRepository;
        this.accountRepository = accountRepository;
    }

    @Override
    public Customer getCustomerById(String id) throws ResourceNotFoundException {
        Customer customer = customerRepository.findById(id).orElse(null);
        if (customer == null) {
            throw new ResourceNotFoundException("Customer not found!");
        }

        return customer;
    }

    @Override
    public Page<Customer> getCustomerList(CustomerFilter filter, Pageable pageable) {

        return customerRepository.getCustomerList(filter, pageable);
    }

    @Override
    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer updateCustomer(Customer customer) throws ResourceNotFoundException {
        Customer currentCustomer = customerRepository.findById(customer.getId()).orElse(null);
        if (currentCustomer == null) {
            throw new ResourceNotFoundException("Customer not found!");
        }

        return customerRepository.save(customer);
    }

    @Override
    public void deleteCustomer(String id) throws ResourceNotFoundException {
        Customer customer = customerRepository.findById(id).orElse(null);
        if (customer == null) {
            throw new ResourceNotFoundException("Customer not found!");
        }

        customerRepository.deleteById(id);
    }

    @Override
    public Page<Account> getAccountsByCustomerId(String id, Pageable pageable) throws ResourceNotFoundException {
        Customer customer = customerRepository.findById(id).orElse(null);
        if (customer == null) {
            throw new ResourceNotFoundException("Customer not found!");
        }

        List<Account> accountList = accountRepository.getAccountsBySetIds(customer.getAccounts());

        return new PageImpl<>(accountList, pageable, accountList.size());
    }

}
