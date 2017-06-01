package com.jeffrychristian.app.common.types;

/**
 * Created by jeffry.christian on 4/29/2017.
 */
public enum ImageCoverType {

    TINY("Tiny"),
    SMALL("Small"),
    MEDIUM("Medium"),
    NORMAL("Normal");

    private String value;

    ImageCoverType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
