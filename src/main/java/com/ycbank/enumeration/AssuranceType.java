package com.ycbank.enumeration;

public enum AssuranceType {

    CNSS("Caisse Nationale de Sécurité Sociale"),
    CNOPS("Caisse nationale des organismes de prévoyance sociale"),
    RMA("Royale marocaine d'assurance"),
    ATLANTA("AtlantaSanad"),
    AXA("AXA"),
    SAHAM("Saham Assurance"),
    WAFA("Wafa Assurance"),
    MAMDA("MAMDA-MCMA"),
    MAROCAINE_VIE("La Marocaine vie - SG"),
    SMAEX("La Société Marocaine d'assurance à l'exportation"),
    SCR("Société Centrale de Réassurance"),
    CIMR("Caisse Interprofessionnelle Marocaine de Retraite");

    private String value;

    AssuranceType(String value) {
        this.value = value;
    }


    public String getValue() {
        return value;
    }

    public static AssuranceType fromString(String text) {
        for (AssuranceType key : AssuranceType.values()) {
            if (key.value.equalsIgnoreCase(text)) {
                return key;
            }
        }
        return null;
    }

}
