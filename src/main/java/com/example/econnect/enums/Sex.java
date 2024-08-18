package com.example.econnect.enums;

public enum Sex {
    MALE("male"),
    FEMALE("female");

    private final String value;

    public String getValue() {
        return value;
    }

    private Sex(String value) {
        this.value = value;
    }
}
