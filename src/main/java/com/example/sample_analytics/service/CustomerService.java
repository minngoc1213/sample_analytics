//package com.example.sample_analytics.service;
//
//import com.example.sample_analytics.dto.filter.CustomerFilter;
//import com.example.sample_analytics.entity.Customer;
//import com.example.sample_analytics.exception.ResourceNotFoundException;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.stereotype.Component;
//
//@Component
//public interface CustomerService {
//    Customer getCustomerById(String id) throws ResourceNotFoundException;
//
//    Page<Customer> getCustomerList(CustomerFilter filter, Pageable pageable) throws ResourceNotFoundException;
//
//    Customer createCustomer(Customer customer);
//
//    Customer updateCustomer(Customer customer) throws ResourceNotFoundException;
//
//}
