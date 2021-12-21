package com.ycbank.enumeration;

public enum BankType {

    BMCE("Bank of Africa"),
    BMCI("BNP Paribas"),
    SG("Société Générale"),
    CIH("CIH Bank");

    private String value;

    BankType(String value) {
        this.value = value;
    }


    public String getValue() {
        return value;
    }

    public static BankType fromString(String text) {
        for (BankType key : BankType.values()) {
            if (key.value.equalsIgnoreCase(text)) {
                return key;
            }
        }
        return null;
    }
}
