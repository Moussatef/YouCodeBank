package com.ycbank.enumeration;

public enum CurrencyType {

    MAD("Dirham marocain"),
    EUR("EURO"),
    USD("Dollar américain"),
    DZD("Dinar algérien"),
    YUAN("YUAN China");

    private String value;

    CurrencyType(String value) {
        this.value = value;
    }


    public String getValue() {
        return value;
    }

    public static CurrencyType fromString(String text) {
        for (CurrencyType key : CurrencyType.values()) {
            if (key.value.equalsIgnoreCase(text)) {
                return key;
            }
        }
        return null;
    }
}
