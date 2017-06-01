package com.jeffrychristian.app.common.types;

/**
 * Created by jeffry.christian on 4/29/2017.
 */
public enum MovieFilterType {

    A_SU    ("Anak / Semua Umur", "Semua Umur"),
    BO_A    ("Bimbingan Orang tua / Anak", "batasan usia 4 s/d 7 tahun"),
    BO      ("Bimbingan Orang tua", "batasan usia 5 s/d 12 tahun"),
    BO_R    ("Bimbingan Orang tua - Remaja", "batasan usia 13 s/d 16 tahun"),
    D       ("Dewasa", "batasan usia minimal 17 tahun");

    private String value;
    private String description;

    MovieFilterType(String value, String description) {
        this.value = value;
        this.description = description;
    }

    public String getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }

}