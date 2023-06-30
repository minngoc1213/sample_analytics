//package com.example.sample_analytics.entity;
//
//import jakarta.validation.constraints.NotNull;
//import jakarta.validation.constraints.Pattern;
//import jakarta.validation.constraints.Positive;
//import org.springframework.data.annotation.Id;
//import org.springframework.data.mongodb.core.mapping.Document;
//
//import java.util.Set;
//
//import static com.example.sample_analytics.constant.Constant.ID_REGEX;
//
//@Document(collection = "accounts")
//public class Account {
//    @Id
//    @Pattern(regexp = ID_REGEX)
//    private String id;
//
//    @NotNull
//    @Positive
//    private Integer account_id;
//
//    @Positive
//    private Integer limit;
//
//    private Set<String> products;
//
//    public Account(String id, @NotNull Integer account_id, Integer limit, Set<String> products) {
//        this.id = id;
//        this.account_id = account_id;
//        this.limit = limit;
//        this.products = products;
//    }
//
//    public String getId() {
//        return id;
//    }
//
//    public void setId(String id) {
//        this.id = id;
//    }
//
//    public Integer getAccount_id() {
//        return account_id;
//    }
//
//    public void setAccount_id(Integer account_id) {
//        this.account_id = account_id;
//    }
//
//    public Integer getLimit() {
//        return limit;
//    }
//
//    public void setLimit(Integer limit) {
//        this.limit = limit;
//    }
//
//    public Set<String> getProducts() {
//        return products;
//    }
//
//    public void setProducts(Set<String> products) {
//        this.products = products;
//    }
//}
