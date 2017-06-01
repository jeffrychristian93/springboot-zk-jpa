package com.jeffrychristian.app.common.types;

/**
 * Created by jeffry.christian on 4/15/2017.
 */
public enum QualityType {

    LOW         ("LOW","240p"),
    STANDART    ("STANDART","480p"),
    MEDIUM      ("MEDIUM","720p"),
    HIGH        ("HIGH","1080p"),
    ULTRA       ("ULTRA","2160p"),
    ULTRA_HIGH  ("ULTRA_HIGH","4320p");

    private String key;
    private String value;

    QualityType(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}
