package com.ycbank.model;

import com.ycbank.enumeration.AssuranceType;
import com.ycbank.enumeration.ClassType;
import com.ycbank.enumeration.CountryType;

public class Coach extends Employee{

    private ClassType classType;

    public Coach() {
        super();
    }

    public Coach(Long id,String firstname, String lastname, String cin, String email, String address,CountryType countryType, Long fundNumber, AssuranceType assuranceType, double salary, ClassType classType) {
        super(id,firstname, lastname, cin, email, address,countryType, fundNumber, assuranceType,salary);
        this.classType = classType;
    }

    public ClassType getClassType() {
        return classType;
    }

    public void setClassType(ClassType classType) {
        this.classType = classType;
    }
}
