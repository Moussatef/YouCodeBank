package com.ycbank.daoImpl;

import com.ycbank.dao.DAO;
import com.ycbank.dao.DAOFactory;
import com.ycbank.enumeration.AssuranceType;
import com.ycbank.enumeration.BankType;
import com.ycbank.enumeration.CountryType;
import com.ycbank.enumeration.CurrencyType;
import com.ycbank.model.Account;
import com.ycbank.model.Person;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class AccountImpl extends DAO<Account> {
    @Override
    public Account find(long id) {
        Account account= null;
        try {
            ResultSet result = this .connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE).executeQuery(
                    "SELECT * FROM person WHERE id = " + id);
            if(result.first())
                account = new Account(BankType.fromString(result.getString("bankType")) ,result.getString("bankCode"), DAOFactory.getPersonImpl().find(result.getLong("owner_id")) ,
                        result.getDate("creationDate"),result.getDouble("balance"), CurrencyType.fromString(result.getString("currencyType")),
                         result.getDate("lastUpdate"));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return account;
    }

    @Override
    public Account create(Account account) {



        String query = "INSERT INTO account(id, bankType,  bankCode,  owner_id,  creationDate,  balance,  currencyType,  lastUpdate) VALUES (?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement prepare = this.connect.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);

            prepare.setLong(1, account.getId());
            prepare.setString(2, account.getBankType().getValue());
            prepare.setString(3, account.getBankCode());
            prepare.setLong(4, account.getOwner().getId());
            prepare.setDate(5,  new Date(account.getCreationDate().getYear(),account.getCreationDate().getMonth(),account.getCreationDate().getDay()));
            prepare.setDouble(6, account.getBalance());
            prepare.setString(7, account.getCurrencyType().getValue());
            prepare.setDate(8, new Date(account.getLastUpdate().getYear(),account.getLastUpdate().getMonth(),account.getLastUpdate().getDay()));;

            prepare.executeUpdate();
            return  account;


        }catch(SQLException e){
            e.printStackTrace();

        }
        return null;
    }

    @Override
    public Account update(Account account) {
        String query = "UPDATE account SET  bankType=?,  bankCode=?, balance=?,  currencyType=?,  lastUpdate=? WHERE id = ? ";
        try {
            PreparedStatement prepare = this.connect.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);


            prepare.setString(1, account.getBankType().getValue());
            prepare.setString(2, account.getBankCode());
            prepare.setDouble(3, account.getBalance());
            prepare.setString(4, account.getCurrencyType().getValue());
            prepare.setDate(5, new Date(account.getLastUpdate().getYear(),account.getLastUpdate().getMonth(),account.getLastUpdate().getDay()));;
            prepare.setLong(6, account.getId());
            prepare.executeUpdate();
            return  account;


        }catch(SQLException e){
            e.printStackTrace();

        }
        return null;
    }

    @Override
    public void delete(Account obj) {

    }
}
