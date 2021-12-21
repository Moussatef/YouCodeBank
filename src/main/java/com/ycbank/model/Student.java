package com.ycbank.model;

import com.ycbank.enumeration.AssuranceType;
import com.ycbank.enumeration.CountryType;

public class Student extends Person{

    private double scholarship;

    public Student(){
        super();
    }

    public Student(Long id,String firstname, String lastname, String cin, String email, String address,CountryType countryType, Long fundNumber, AssuranceType assuranceType, double scholarship){
        super(id,firstname,lastname,cin,email,address,countryType,fundNumber,assuranceType);
        this.scholarship = scholarship;
    }

    public double getScholarship() {
        return scholarship;
    }

    public void setScholarship(double scholarship) {
        this.scholarship = scholarship;
    }
}
