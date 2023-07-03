package com.example.sample_analytics.dto.mapper;

import com.example.sample_analytics.common.mapper.EntityMapper;
import com.example.sample_analytics.dto.CustomerDTO;
import com.example.sample_analytics.entity.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper extends EntityMapper<CustomerDTO, Customer> {
}
