package com.jeffrychristian.app.common.types;

/**
 * Created by jeffry.christian on 12/3/2016.
 */
public enum GenderType {

    MALE("Male"), FEMALE("Female");

    private String value;

    GenderType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
