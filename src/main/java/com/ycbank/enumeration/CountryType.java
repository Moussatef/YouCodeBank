package com.ycbank.enumeration;

public enum CountryType {

    MA("MAROC"),
    DZ("Algérie"),
    CO("Colombia"),
    EG("Egypt"),
    CG("Congo");

    private String value;

    CountryType(String value) {
        this.value = value;
    }


    public String getValue() {
        return value;
    }

    public static CountryType fromString(String text) {
        for (CountryType key : CountryType.values()) {
            if (key.value.equalsIgnoreCase(text)) {
                return key;
            }
        }
        return null;
    }

}
