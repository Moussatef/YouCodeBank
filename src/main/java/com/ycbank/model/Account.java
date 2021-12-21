package com.ycbank.model;

import com.ycbank.enumeration.BankType;
import com.ycbank.enumeration.CurrencyType;

import java.util.Date;

public class Account {

    private Long id;
    private BankType bankType;
    private String bankCode;
    private Person owner;
    private Date creationDate;
    private double balance;
    private CurrencyType currencyType;
    private Date lastUpdate;

    public Account(){

    }

    public Account(Long id, BankType bankType, String bankCode, Person owner, Date creationDate, double balance, CurrencyType currencyType, Date lastUpdate) {
        this.id = id;
        this.bankType = bankType;
        this.bankCode = bankCode;
        this.owner = owner;
        this.creationDate = creationDate;
        this.balance = balance;
        this.currencyType = currencyType;
        this.lastUpdate = lastUpdate;
    }

    public Account(Long id, BankType bankType, String bankCode, double balance, CurrencyType currencyType, Date lastUpdate) {
        this.id = id;
        this.bankType = bankType;
        this.bankCode = bankCode;
        this.balance = balance;
        this.currencyType = currencyType;
        this.lastUpdate = lastUpdate;
    }

    public Account(BankType bankType, String bankCode, Person owner, Date creationDate, double balance, CurrencyType currencyType, Date lastUpdate) {
        this.id = 1L + (long) (Math.random() * (100L - 1L));
        this.bankType = bankType;
        this.bankCode = bankCode;
        this.owner = owner;
        this.creationDate = creationDate;
        this.balance = balance;
        this.currencyType = currencyType;
        this.lastUpdate = lastUpdate;
    }

    public Long getId() {
        return id;
    }

    public BankType getBankType() {
        return bankType;
    }

    public void setBankType(BankType bankType) {
        this.bankType = bankType;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public CurrencyType getCurrencyType() {
        return currencyType;
    }

    public void setCurrencyType(CurrencyType currencyType) {
        this.currencyType = currencyType;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", bankType=" + bankType +
                ", bankCode='" + bankCode + '\'' +
                ", owner=" + owner +
                ", creationDate=" + creationDate +
                ", balance=" + balance +
                ", currencyType=" + currencyType +
                ", lastUpdate=" + lastUpdate +
                '}';
    }
}
