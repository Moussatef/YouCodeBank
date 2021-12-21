package com.ycbank.daoImpl;

import com.ycbank.dao.DAO;
import com.ycbank.enumeration.AssuranceType;
import com.ycbank.enumeration.CountryType;
import com.ycbank.model.Employee;
import com.ycbank.model.Student;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public class EmployeeImpl extends DAO<Employee> {

    @Override
    public Employee find(long id) {
        Employee employee= null;
        try {
            ResultSet result = this .connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE).executeQuery(
                    "SELECT * FROM person as p,employee as e WHERE e.person_id=p.id and e.person_id = " + id);
            if(result.first())
                employee = new Employee(id,result.getString("firstname"),result.getString("lastname"),result.getString("cin"),
                        result.getString("email"),result.getString("address"), CountryType.fromString(result.getString("country_type")),
                        result.getLong("fund_number"), AssuranceType.fromString(result.getString("assurance_type")),result.getDouble("salary"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;
    }

    @Override
    public Employee create(Employee employee) {
        try {
            PreparedStatement personStatement = this.connect.prepareStatement(
                    "INSERT INTO person (id,firstname,lastname,cin,email,address,fund_number,assurance_type,country_type) VALUES(?,?,?,?,?,?,?,?,?)");
            personStatement.setLong(1, employee.getId());
            personStatement.setString(2, employee.getFirstname());
            personStatement.setString(3, employee.getLastname());
            personStatement.setString(4, employee.getCin());
            personStatement.setString(5, employee.getEmail());
            personStatement.setString(6, employee.getAddress());
            personStatement.setLong(7, employee.getFundNumber());
            personStatement.setString(8, employee.getAssuranceType().getValue());
            personStatement.setString(9, employee.getCountryType().getValue());

            if(Objects.isNull(this.find(employee.getId()))){
                personStatement.executeUpdate();

                PreparedStatement employeeStatement = this.connect.prepareStatement("INSERT INTO employee (salary,person_id) VALUES(?,?)");
                employeeStatement.setDouble(1, employee.getSalary());
                employeeStatement.setDouble(2, employee.getId());
                employeeStatement.executeUpdate();
            }else{
                System.out.println("Vous etes déjà dans la base");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;
    }

    @Override
    public Employee update(Employee employee) {
        try {

            PreparedStatement personStatement = this.connect.prepareStatement(
                    "UPDATE person set firstname = ? ,lastname = ?,cin = ?,email = ?,address = ?,country_type = ?,fund_number = ?,assurance_type = ? WHERE id= ?");

            personStatement.setString(1, employee.getFirstname());
            personStatement.setString(2, employee.getLastname());
            personStatement.setString(3, employee.getCin());
            personStatement.setString(4, employee.getEmail());
            personStatement.setString(5, employee.getAddress());
            personStatement.setString(6, employee.getCountryType().getValue());
            personStatement.setLong(7, employee.getFundNumber());
            personStatement.setString(8, employee.getAssuranceType().getValue());
            personStatement.setLong(9, employee.getId());

            PreparedStatement studentStatement = this.connect.prepareStatement(
                    "UPDATE employee set salary = ? WHERE person_id= ?");

            studentStatement.setDouble(1, employee.getSalary());
            studentStatement.setLong(2, employee.getId());

            personStatement.executeUpdate();
            studentStatement.executeUpdate();
            employee = this.find(employee.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;
    }

    @Override
    public void delete(Employee employee) {
        try {
            this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE).executeUpdate(
                    "DELETE FROM employee WHERE person_id = " + employee.getId());
            this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE).executeUpdate(
                    "DELETE FROM person WHERE id = " + employee.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
