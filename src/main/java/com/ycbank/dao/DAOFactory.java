package com.ycbank.dao;

import com.ycbank.daoImpl.CoachImpl;
import com.ycbank.daoImpl.EmployeeImpl;
import com.ycbank.daoImpl.PersonImpl;
import com.ycbank.daoImpl.StudentImpl;
import com.ycbank.interfaceImpl.IPersonImpl;
import com.ycbank.interfaceImpl.IStudentImpl;
import com.ycbank.model.Coach;
import com.ycbank.model.Employee;
import com.ycbank.model.Person;
import com.ycbank.model.Student;

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
    // ------------------------------------------------------------------------------|


    // by interface -----------------------------------------------------------------|
    public static IDAO<Person> getIPecrsonImpl(){ return new IPersonImpl(); }   //---|
    public static IDAO<Student> getIStudentImpl(){ return new IStudentImpl(); }  //--|
    // ------------------------------------------------------------------------------|
}
