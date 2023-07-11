package com.example.sample_analytics.dto;

import java.util.Date;

public class CustomerDTO {
    private String id;

    private String username;

    private String name;

    private String address;

    private Date birthdate;

    private String email;

    private Boolean active;

    public CustomerDTO() {
    }

    public CustomerDTO(String id, String username, String name, String address, Date birthdate, String email, Boolean active) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.address = address;
        this.birthdate = birthdate;
        this.email = email;
        this.active = active;
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
}
