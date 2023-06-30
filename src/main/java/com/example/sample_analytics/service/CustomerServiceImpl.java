//package com.example.sample_analytics.service;
//
//import com.example.sample_analytics.dto.filter.CustomerFilter;
//import com.example.sample_analytics.entity.Customer;
//import com.example.sample_analytics.exception.ResourceNotFoundException;
//import com.example.sample_analytics.repository.CustomerRepository;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.stereotype.Service;
//
//@Service
//public class CustomerServiceImpl implements CustomerService {
//
//    private final CustomerRepository customerRepository;
//
//    public CustomerServiceImpl(CustomerRepository customerRepository) {
//        this.customerRepository = customerRepository;
//    }
//
//    @Override
//    public Customer getCustomerById(String id) throws ResourceNotFoundException {
//        Customer customer = customerRepository.findById(id).orElse(null);
//        if (customer == null) {
//            throw new ResourceNotFoundException("Customer not found!");
//        }
//
//        return customer;
//    }
//
//    @Override
//    public Page<Customer> getCustomerList(CustomerFilter filter, Pageable pageable) throws ResourceNotFoundException {
//        return customerRepository.getCustomerList(filter, pageable);
//    }
//
//    @Override
//    public Customer createCustomer(Customer customer) {
//        return customerRepository.save(customer);
//    }
//
//    @Override
//    public Customer updateCustomer(Customer customer) {
//        Customer currentCustomer = customerRepository.findById(customer.getId()).orElse(null);
//        if (currentCustomer == null) {
//            throw new ResourceNotFoundException("Customer not found!");
//        }
//
//        return customerRepository.save(customer);
//    }
//
//}
