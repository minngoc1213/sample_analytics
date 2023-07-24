package com.example.sample_analytics.user.dto.mapper;

import com.example.sample_analytics.common.mapper.EntityMapper;
import com.example.sample_analytics.user.dto.CustomerDTO;
import com.example.sample_analytics.user.entity.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper extends EntityMapper<CustomerDTO, Customer> {
}
