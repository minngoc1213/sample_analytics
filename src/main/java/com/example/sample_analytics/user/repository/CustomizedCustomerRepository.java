package com.example.sample_analytics.user.repository;

import com.example.sample_analytics.user.dto.filter.CustomerFilter;
import com.example.sample_analytics.user.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CustomizedCustomerRepository {
    Page<Customer> getCustomerList(CustomerFilter filter, Pageable pageable);

}
