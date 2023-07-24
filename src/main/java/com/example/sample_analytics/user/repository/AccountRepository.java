package com.example.sample_analytics.user.repository;

import com.example.sample_analytics.user.entity.Account;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface AccountRepository extends MongoRepository<Account, String>, CustomizedAccountRepository {
    @Query("{ 'account_id': { $in : ?0 } }")
    List<Account> getAccountsBySetIds(Set<Integer> idSet);

}
