package com.example.sample_analytics.user.repository;

import com.example.sample_analytics.user.entity.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, String>, CustomizedCustomerRepository {

}
