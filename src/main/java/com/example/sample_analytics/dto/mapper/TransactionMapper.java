package com.example.sample_analytics.dto.mapper;

import com.example.sample_analytics.common.mapper.EntityMapper;
import com.example.sample_analytics.dto.TransactionDTO;
import com.example.sample_analytics.entity.Transaction;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TransactionMapper extends EntityMapper<TransactionDTO, Transaction> {
}
