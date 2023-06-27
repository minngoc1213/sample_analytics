package com.example.sample_analytics.domain;

import jakarta.validation.constraints.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.*;

@Document(collection = "customers")
public class Customer {
    @Id
    @Pattern(regexp = "^[a-z0-9]*$")
    private String id;

    @NotNull
    @Pattern(regexp = "^[a-z0-9]*$")
    private String username;

    private String name;

    private String address;

    @Past
    private Date birthdate;

    @Email
    private String email;

    @NotNull
    private Boolean active;

    private List<Integer> accounts;

    @Field("tier_and_details")
    private Map<String, TierAndDetails> tierAndDetailsMap;

    public static class TierAndDetails {
        @NotNull
        private String tier;

        @NotNull
        private List<String> benefits;

        @NotNull
        private Boolean active;

        @NotNull
        @Pattern(regexp = "^[a-z0-9]*$")
        private String id;

        public TierAndDetails(@NotNull String tier, @NotNull List<String> benefits, @NotNull Boolean active, @NotNull String id) {
            this.tier = tier;
            this.benefits = benefits;
            this.active = active;
            this.id = id;
        }

        public String getTier() {
            return tier;
        }

        public void setTier(String tier) {
            this.tier = tier;
        }

        public List<String> getBenefits() {
            return benefits;
        }

        public void setBenefits(List<String> benefits) {
            this.benefits = benefits;
        }

        public Boolean getActive() {
            return active;
        }

        public void setActive(Boolean active) {
            this.active = active;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }

    public Customer(String id, @NotNull String username, String name, String address, Date birthdate, String email, @NotNull Boolean active, List<Integer> accounts, Map<String, TierAndDetails> tierAndDetailsMap) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.address = address;
        this.birthdate = birthdate;
        this.email = email;
        this.active = active;
        this.accounts = accounts;
        this.tierAndDetailsMap = tierAndDetailsMap;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public List<Integer> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Integer> accounts) {
        this.accounts = accounts;
    }

    public Map<String, TierAndDetails> getTierAndDetailsMap() {
        return tierAndDetailsMap;
    }

    public void setTierAndDetailsMap(Map<String, TierAndDetails> tierAndDetailsMap) {
        this.tierAndDetailsMap = tierAndDetailsMap;
    }
}
