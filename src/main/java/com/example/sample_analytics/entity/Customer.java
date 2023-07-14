package com.example.sample_analytics.entity;

import com.example.sample_analytics.common.validator.DatabaseIdConstraint;
import com.example.sample_analytics.common.validator.DatabaseIntegerListConstraint;
import com.example.sample_analytics.common.validator.DatabaseStringListConstraint;
import jakarta.validation.constraints.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.*;

import static com.example.sample_analytics.common.constant.Constant.ID_REGEX;
import static com.example.sample_analytics.common.constant.Constant.STRING_MAX_LENGTH;

@Document(collection = "customers")
public class Customer {
    @DatabaseIdConstraint
    private String id;

    @NotBlank
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

    @DatabaseIntegerListConstraint
    private Set<Integer> accounts = new HashSet<>();

    @Field(name = "tier_and_details")
    private Map<String, TierAndDetails> tierAndDetails = new HashMap<>();

    public static class TierAndDetails {
        @NotBlank
        private String tier;

        @DatabaseStringListConstraint
        private Set<String> benefits = new HashSet<>();

        private Boolean active;

        @DatabaseIdConstraint
        private String id;

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

    public Set<Integer> getAccounts() {
        return accounts;
    }

    public void setAccounts(Set<Integer> accounts) {
        this.accounts = accounts;
    }

    public Map<String, TierAndDetails> getTierAndDetails() {
        return tierAndDetails;
    }

    public void setTierAndDetails(Map<String, TierAndDetails> tierAndDetails) {
        this.tierAndDetails = tierAndDetails;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Customer)) {
            return false;
        }

        return username.equals(((Customer) o).username);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(username);
    }
}
