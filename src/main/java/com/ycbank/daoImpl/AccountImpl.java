package com.ycbank.daoImpl;

import com.ycbank.dao.DAO;
import com.ycbank.dao.DAOFactory;
import com.ycbank.enumeration.AssuranceType;
import com.ycbank.enumeration.BankType;
import com.ycbank.enumeration.CountryType;
import com.ycbank.enumeration.CurrencyType;
import com.ycbank.model.Account;
import com.ycbank.model.Person;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountImpl extends DAO<Account> {
    @Override
    public Account find(long id) {
        Account account= null;
        try {
            ResultSet result = this .connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE).executeQuery(
                    "SELECT * FROM person WHERE id = " + id);
            if(result.first())
                account = new Account(id, BankType.fromString(result.getString("bankType")) ,result.getString("bankCode"), DAOFactory.getPersonImpl().find(result.getLong("owner_id")) ,
                        result.getDate("creationDate"),result.getDouble("balance"), CurrencyType.fromString(result.getString("currencyType")),
                         result.getDate("lastUpdate"));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return account;
    }

    @Override
    public Account create(Account obj) {
        return null;
    }

    @Override
    public Account update(Account obj) {
        return null;
    }

    @Override
    public void delete(Account obj) {

    }
}
