package com.ycbank.model;

import com.ycbank.enumeration.CurrencyType;

import java.time.Instant;

public class Transaction {

    private Long id;
    private String transactionNumber;
    private Instant date;
    private String description;
    private char sens; // débit ou crédit (d/c)
    private double amountLocal;
    private CurrencyType currencyType;
    private double currencyAmount;
    private Account from;
    private Account to;
    private String comments;

    public Transaction(){

    }

    public Transaction(String transactionNumber, Instant date, String description, char sens, double amountLocal, CurrencyType currencyType, double currencyAmount, Account from, Account to, String comments) {
        this.id = 1L + (long) (Math.random() * (199L - 1L));
        this.transactionNumber = transactionNumber;
        this.date = date;
        this.description = description;
        this.sens = sens;
        this.amountLocal = amountLocal;
        this.currencyType = currencyType;
        this.currencyAmount = currencyAmount;
        this.from = from;
        this.to = to;
        this.comments = comments;
    }

    public Long getId() {
        return id;
    }

    public String getTransactionNumber() {
        return transactionNumber;
    }

    public void setTransactionNumber(String transactionNumber) {
        this.transactionNumber = transactionNumber;
    }

    public Instant getDate() {
        return date;
    }

    public void setDate(Instant date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public char getSens() {
        return sens;
    }

    public void setSens(char sens) {
        this.sens = sens;
    }

    public double getAmountLocal() {
        return amountLocal;
    }

    public void setAmountLocal(double amountLocal) {
        this.amountLocal = amountLocal;
    }

    public CurrencyType getCurrencyType() {
        return currencyType;
    }

    public void setCurrencyType(CurrencyType currencyType) {
        this.currencyType = currencyType;
    }

    public double getCurrencyAmount() {
        return currencyAmount;
    }

    public void setCurrencyAmount(double currencyAmount) {
        this.currencyAmount = currencyAmount;
    }

    public Account getFrom() {
        return from;
    }

    public void setFrom(Account from) {
        this.from = from;
    }

    public Account getTo() {
        return to;
    }

    public void setTo(Account to) {
        this.to = to;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", transactionNumber='" + transactionNumber + '\'' +
                ", date=" + date +
                ", description='" + description + '\'' +
                ", sens=" + sens +
                ", amountLocal=" + amountLocal +
                ", currencyType=" + currencyType +
                ", currencyAmount=" + currencyAmount +
                ", from=" + from +
                ", to=" + to +
                ", comments='" + comments + '\'' +
                '}';
    }
}
