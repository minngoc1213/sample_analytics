package com.example.sample_analytics.repository;

import com.example.sample_analytics.dto.filter.CustomerFilter;
import com.example.sample_analytics.entity.Customer;

import java.util.List;

public interface CustomizedCustomerRepository {
    List<Customer> getCustomerList(CustomerFilter filter);

}
