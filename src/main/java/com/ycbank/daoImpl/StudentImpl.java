package com.ycbank.daoImpl;

import com.ycbank.dao.DAO;
import com.ycbank.enumeration.AssuranceType;
import com.ycbank.enumeration.CountryType;
import com.ycbank.model.Person;
import com.ycbank.model.Student;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public class StudentImpl extends DAO<Student> {

    @Override
    public Student find(long id) {
        Student student= null;
        try {
            ResultSet result = this .connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE).executeQuery(
                    "SELECT * FROM person as p,student as s WHERE s.person_id=p.id and s.person_id = " + id);
            if(result.first())
                student = new Student(id,result.getString("firstname"),result.getString("lastname"),result.getString("cin"),
                        result.getString("email"),result.getString("address"), CountryType.fromString(result.getString("country_type")),
                        result.getLong("fund_number"), AssuranceType.fromString(result.getString("assurance_type")),result.getDouble("scholarship"));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }

    @Override
    public Student create(Student student) {
        try {
            PreparedStatement personStatement = this.connect.prepareStatement(
                    "INSERT INTO person (id,firstname,lastname,cin,email,address,fund_number,assurance_type,country_type) VALUES(?,?,?,?,?,?,?,?,?)");
            personStatement.setLong(1, student.getId());
            personStatement.setString(2, student.getFirstname());
            personStatement.setString(3, student.getLastname());
            personStatement.setString(4, student.getCin());
            personStatement.setString(5, student.getEmail());
            personStatement.setString(6, student.getAddress());
            personStatement.setLong(7, student.getFundNumber());
            personStatement.setString(8, student.getAssuranceType().getValue());
            personStatement.setString(9, student.getCountryType().getValue());

            if(Objects.isNull(this.find(student.getId()))){
                personStatement.executeUpdate();

                PreparedStatement studentStatement = this.connect.prepareStatement("INSERT INTO student (scholarship,person_id) VALUES(?,?)");
                studentStatement.setDouble(1, student.getScholarship());
                studentStatement.setDouble(2, student.getId());
                studentStatement.executeUpdate();
            }else{
                System.out.println("Vous etes déjà dans la base");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }

    @Override
    public Student update(Student student) {
        try {

            PreparedStatement personStatement = this.connect.prepareStatement(
                    "UPDATE person set firstname = ? ,lastname = ?,cin = ?,email = ?,address = ?,country_type = ?,fund_number = ?,assurance_type = ? WHERE id= ?");

            personStatement.setString(1, student.getFirstname());
            personStatement.setString(2, student.getLastname());
            personStatement.setString(3, student.getCin());
            personStatement.setString(4, student.getEmail());
            personStatement.setString(5, student.getAddress());
            personStatement.setString(6, student.getCountryType().getValue());
            personStatement.setLong(7, student.getFundNumber());
            personStatement.setString(8, student.getAssuranceType().getValue());
            personStatement.setLong(9, student.getId());

            PreparedStatement studentStatement = this.connect.prepareStatement(
                    "UPDATE student set scholarship = ? WHERE person_id= ?");

            studentStatement.setDouble(1, student.getScholarship());
            studentStatement.setLong(2, student.getId());

            personStatement.executeUpdate();
            studentStatement.executeUpdate();
            student = this.find(student.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return student;
    }

    @Override
    public void delete(Student student) {
        try {
            this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE).executeUpdate(
                    "DELETE FROM student WHERE person_id = " + student.getId());
            this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE).executeUpdate(
                    "DELETE FROM person WHERE id = " + student.getId());

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
