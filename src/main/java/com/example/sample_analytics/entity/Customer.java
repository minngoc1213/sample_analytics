package com.example.sample_analytics.entity;

import jakarta.validation.constraints.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.*;

import static com.example.sample_analytics.common.constant.Constant.ID_REGEX;
import static com.example.sample_analytics.common.constant.Constant.STRING_MAX_LENGTH;

@Document(collection = "customers")
public class Customer {
    @Id
    @Pattern(regexp = ID_REGEX)
    private String id;

    @NotNull
    @Pattern(regexp = ID_REGEX)
    private String username;

    @Size(max = STRING_MAX_LENGTH)
    private String name;

    @Size(max = STRING_MAX_LENGTH)
    private String address;

    @Past
    private Date birthdate;

    @Email
    private String email;

    private Boolean active;

    private Set<Integer> accounts;

    private Map<String, TierAndDetails> tier_and_details;

    public static class TierAndDetails {
        @NotNull
        private String tier;

        @Size(max = STRING_MAX_LENGTH)
        private Set<String> benefits;

        private Boolean active;

        @NotNull
        @Pattern(regexp = ID_REGEX)
        private String id;

        public TierAndDetails(@NotNull String tier, Set<String> benefits, Boolean active, @NotNull String id) {
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

        public Set<String> getBenefits() {
            return benefits;
        }

        public void setBenefits(Set<String> benefits) {
            this.benefits = benefits;
        }

        public Boolean isActive() {
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

    public Customer(String id, @NotNull String username, String name, String address, Date birthdate, String email, Boolean active, Set<Integer> accounts, Map<String, TierAndDetails> tier_and_details) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.address = address;
        this.birthdate = birthdate;
        this.email = email;
        this.active = active;
        this.accounts = accounts;
        this.tier_and_details = tier_and_details;
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

    public Boolean isActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Set<Integer> getAccounts() {
        return accounts;
    }

    public void setAccounts(Set<Integer> accounts) {
        this.accounts = accounts;
    }

    public Map<String, TierAndDetails> getTier_and_details() {
        return tier_and_details;
    }

    public void setTier_and_details(Map<String, TierAndDetails> tier_and_details) {
        this.tier_and_details = tier_and_details;
    }
}
