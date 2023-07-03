package com.example.sample_analytics.dto.filter;

public class CustomerFilter {
     private String name = null;

     private String address = null;

     private String active = null;

     public CustomerFilter() {

     }

     public CustomerFilter(String name, String address, String active) {
         this.name = name;
         this.address = address;
         this.active = active;
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

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }
}
