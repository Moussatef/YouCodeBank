package com.ycbank.dao;

import com.ycbank.daoImpl.*;
import com.ycbank.interfaceImpl.IPersonImpl;
import com.ycbank.interfaceImpl.IStudentImpl;
import com.ycbank.model.*;

import com.ycbank.interfaces.IDAO;

public class DAOFactory {

    // by abstract ------------------------------------------------------------------|
    public static DAO<Person> getPersonImpl(){
        return new PersonImpl();
    }     //----|
    public static DAO<Student> getStudentImpl(){ return new StudentImpl(); }  //-----|
    public static DAO<Employee> getEmployeeImpl(){
        return new EmployeeImpl();
    } //--|
    public static DAO<Coach> getCoachImpl(){
        return new CoachImpl();
    } //-----------|
    public static DAO<Account> getAccountImpl(){
        return new AccountImpl();
    }



    // ------------------------------------------------------------------------------|


    // by interface -----------------------------------------------------------------|
    public static IDAO<Person> getIPecrsonImpl(){ return new IPersonImpl(); }   //---|
    public static IDAO<Student> getIStudentImpl(){ return new IStudentImpl(); }  //--|
    // ------------------------------------------------------------------------------|
}
