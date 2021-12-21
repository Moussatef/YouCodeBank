package com.ycbank.model;

import com.ycbank.enumeration.AssuranceType;
import com.ycbank.enumeration.CountryType;

public class Person {

    private Long id;
    private String firstname;
    private String lastname;
    private String cin;
    private String email;
    private String address;
    private CountryType countryType;
    private Long fundNumber; // N° de caisse
    private AssuranceType assuranceType;

    public Person(){
        this.id = 1L + (long) (Math.random() * (100L - 1L));
    }

    public Person(Long id,String firstname, String lastname, String cin, String email, String address,CountryType countryType,Long fundNumber,AssuranceType assuranceType) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.cin = cin;
        this.email = email;
        this.address = address;
        this.countryType = countryType;
        this.fundNumber = fundNumber;
        this.assuranceType = assuranceType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getFundNumber() {
        return fundNumber;
    }

    public void setFundNumber(Long fundNumber) {
        this.fundNumber = fundNumber;
    }

    public AssuranceType getAssuranceType() {
        return assuranceType;
    }

    public void setAssuranceType(AssuranceType assuranceType) {
        this.assuranceType = assuranceType;
    }

    public CountryType getCountryType() {
        return countryType;
    }

    public void setCountryType(CountryType countryType) {
        this.countryType = countryType;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", cin='" + cin + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", fundNumber=" + fundNumber +
                ", assuranceType=" + assuranceType +
                '}';
    }
}
