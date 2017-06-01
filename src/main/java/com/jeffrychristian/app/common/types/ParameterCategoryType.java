package com.jeffrychristian.app.common.types;

/**
 * Created by jeffry.christian on 4/15/2017.
 */
public enum ParameterCategoryType {
    BUSINESS("Business"),
    SYSTEM("System");

    private String value;

    ParameterCategoryType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
