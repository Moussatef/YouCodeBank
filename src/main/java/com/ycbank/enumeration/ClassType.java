package com.ycbank.enumeration;

public enum ClassType {

    JAVA("FullStack Java/Angular"),
    DOT_NET("FullStack .Net/Angular"),
    PHP("FullStack PHP/VueJS"),
    JS("FullStack NodeJS/React");

    private String value;

    ClassType(String value) {
        this.value = value;
    }


    public String getValue() {
        return value;
    }

    public static ClassType fromString(String text) {
        for (ClassType key : ClassType.values()) {
            if (key.value.equalsIgnoreCase(text)) {
                return key;
            }
        }
        return null;
    }
}
