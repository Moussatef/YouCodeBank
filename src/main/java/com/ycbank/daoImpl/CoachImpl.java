package com.ycbank.daoImpl;

import com.ycbank.dao.DAO;
import com.ycbank.enumeration.AssuranceType;
import com.ycbank.enumeration.ClassType;
import com.ycbank.enumeration.CountryType;
import com.ycbank.model.Coach;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public class CoachImpl extends DAO<Coach> {
    @Override
    public Coach find(long id) {
        Coach coach= null;
        try {
            ResultSet result = this .connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE).executeQuery(
                    "SELECT * FROM person as p,employee as e,coach as c WHERE e.person_id=p.id and c.employee_id=e.person_id and c.employee_id = " + id);
            if(result.first())
                coach = new Coach(id,result.getString("firstname"),result.getString("lastname"),result.getString("cin"),
                        result.getString("email"),result.getString("address"), CountryType.fromString(result.getString("country_type")),
                        result.getLong("fund_number"), AssuranceType.fromString(result.getString("assurance_type")),result.getDouble("salary"),
                        ClassType.fromString(result.getString("class_type")));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return coach;
    }

    @Override
    public Coach create(Coach coach) {
        try {
            PreparedStatement personStatement = this.connect.prepareStatement(
                    "INSERT INTO person (id,firstname,lastname,cin,email,address,fund_number,assurance_type,country_type) VALUES(?,?,?,?,?,?,?,?,?)");
            personStatement.setLong(1, coach.getId());
            personStatement.setString(2, coach.getFirstname());
            personStatement.setString(3, coach.getLastname());
            personStatement.setString(4, coach.getCin());
            personStatement.setString(5, coach.getEmail());
            personStatement.setString(6, coach.getAddress());
            personStatement.setLong(7, coach.getFundNumber());
            personStatement.setString(8, coach.getAssuranceType().getValue());
            personStatement.setString(9, coach.getCountryType().getValue());

            if(Objects.isNull(this.find(coach.getId()))){
                personStatement.executeUpdate();

                PreparedStatement employeeStatement = this.connect.prepareStatement("INSERT INTO employee (salary,person_id) VALUES(?,?)");
                employeeStatement.setDouble(1, coach.getSalary());
                employeeStatement.setDouble(2, coach.getId());
                employeeStatement.executeUpdate();

                PreparedStatement coachStatement = this.connect.prepareStatement("INSERT INTO coach (class_type,employee_id) VALUES(?,?)");
                coachStatement.setString(1, coach.getClassType().getValue());
                coachStatement.setDouble(2, coach.getId());
                coachStatement.executeUpdate();
            }else{
                System.out.println("Vous etes déjà dans la base");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return coach;
    }

    @Override
    public Coach update(Coach coach) {
        try {

            PreparedStatement personStatement = this.connect.prepareStatement(
                    "UPDATE person set firstname = ? ,lastname = ?,cin = ?,email = ?,address = ?,country_type = ?,fund_number = ?,assurance_type = ? WHERE id= ?");

            personStatement.setString(1, coach.getFirstname());
            personStatement.setString(2, coach.getLastname());
            personStatement.setString(3, coach.getCin());
            personStatement.setString(4, coach.getEmail());
            personStatement.setString(5, coach.getAddress());
            personStatement.setString(6, coach.getCountryType().getValue());
            personStatement.setLong(7, coach.getFundNumber());
            personStatement.setString(8, coach.getAssuranceType().getValue());
            personStatement.setLong(9, coach.getId());

            PreparedStatement studentStatement = this.connect.prepareStatement(
                    "UPDATE employee set salary = ? WHERE person_id= ?");

            studentStatement.setDouble(1, coach.getSalary());
            studentStatement.setLong(2, coach.getId());

            PreparedStatement coachStatement = this.connect.prepareStatement(
                    "UPDATE coach set class_type = ? WHERE employee_id= ?");

            coachStatement.setString(1, coach.getClassType().getValue());
            coachStatement.setLong(2, coach.getId());

            personStatement.executeUpdate();
            studentStatement.executeUpdate();
            coachStatement.executeUpdate();

            coach = this.find(coach.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return coach;
    }

    @Override
    public void delete(Coach coach) {
        try {
            this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE).executeUpdate(
                    "DELETE FROM coach WHERE employee_id = " + coach.getId());
            this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE).executeUpdate(
                    "DELETE FROM employee WHERE person_id = " + coach.getId());
            this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE).executeUpdate(
                    "DELETE FROM person WHERE id = " + coach.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
