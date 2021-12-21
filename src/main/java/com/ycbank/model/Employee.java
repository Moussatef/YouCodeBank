package com.ycbank.model;

import com.ycbank.enumeration.AssuranceType;
import com.ycbank.enumeration.CountryType;

public class Employee extends Person{

    private double salary;

    public Employee(){
        super();
    }

    public Employee(Long id,String firstname, String lastname, String cin, String email, String address,CountryType countryType, Long fundNumber, AssuranceType assuranceType, double salary){
        super(id,firstname,lastname,cin,email,address,countryType,fundNumber,assuranceType);
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
