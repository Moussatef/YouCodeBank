package com.ycbank.interfaceImpl;

import com.ycbank.enumeration.AssuranceType;
import com.ycbank.enumeration.CountryType;
import com.ycbank.interfaces.IDAO;
import com.ycbank.model.Person;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public class IPersonImpl implements IDAO<Person> {

    @Override
    public Person find(long id) {
        Person person= null;
        try {
            ResultSet result = this .connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE).executeQuery(
                    "SELECT * FROM person WHERE id = " + id);
            if(result.first())
                person = new Person(id,result.getString("firstname"),result.getString("lastname"),result.getString("cin"),
                        result.getString("email"),result.getString("address"), CountryType.fromString(result.getString("country_type")),
                        result.getLong("fund_number"), AssuranceType.fromString(result.getString("assurance_type")));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return person;
    }

    @Override
    public Person create(Person person) {
        try {
            PreparedStatement prepare = this.connect.prepareStatement(
                    "INSERT INTO person (id,firstname,lastname,cin,email,address,fund_number,assurance_type,country_type) VALUES(?,?,?,?,?,?,?,?,?)");
            prepare.setLong(1, person.getId());
            prepare.setString(2, person.getFirstname());
            prepare.setString(3, person.getLastname());
            prepare.setString(4, person.getCin());
            prepare.setString(5, person.getEmail());
            prepare.setString(6, person.getAddress());
            prepare.setLong(7, person.getFundNumber());
            prepare.setString(8, person.getAssuranceType().getValue());
            prepare.setString(9, person.getCountryType().getValue());

            if(Objects.isNull(this.find(person.getId()))){
                prepare.executeUpdate();
                person = this.find(person.getId());
            }else{
                System.out.println("Vous etes déjà dans la base");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return person;
    }

    @Override
    public Person update(Person person) {
        try {

            PreparedStatement prepare = this.connect.prepareStatement(
                    "UPDATE person set firstname = ? ,lastname = ?,cin = ?,email = ?,address = ?,fund_number = ?,assurance_type = ?,country_type = ? WHERE id= ?");

            prepare.setString(1, person.getFirstname());
            prepare.setString(2, person.getLastname());
            prepare.setString(3, person.getCin());
            prepare.setString(4, person.getEmail());
            prepare.setString(5, person.getAddress());
            prepare.setString(6, person.getCountryType().getValue());
            prepare.setLong(7, person.getFundNumber());
            prepare.setString(8, person.getAssuranceType().getValue());
            prepare.setLong(9, person.getId());

            prepare.executeUpdate();
            person = this.find(person.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return person;
    }

    @Override
    public void delete(Person person) {
        try {
            this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE).executeUpdate(
                    "DELETE FROM person WHERE id = " + person.getId());

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
