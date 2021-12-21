package com.ycbank.daoImpl;

import com.ycbank.dao.DAO;
import com.ycbank.model.Transaction;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TransactionImpl extends DAO<Transaction> {
    @Override
    public Transaction find(long id) {
        return null;
    }

    @Override
    public Transaction create(Transaction obj) {

        String query ="INSERT INTO transaction(id,transactionNumber,date,description,sens,amountLocal,currencyType,currencyAmount,from_id,to_id,comments) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        try{
            PreparedStatement prepare = this.connect.prepareStatement(query,PreparedStatement.RETURN_GENERATED_KEYS);

            prepare.setLong(1,obj.getId());
            prepare.setString(2,obj.getTransactionNumber());
            prepare.setDate(3, Date.valueOf(LocalDate.parse(obj.getDate().toString()).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))));
            prepare.setString(4,obj.getDescription());
            //prepare.(5,obj.getSens());


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }

    @Override
    public Transaction update(Transaction obj) {
        return null;
    }

    @Override
    public void delete(Transaction obj) {

    }
}
