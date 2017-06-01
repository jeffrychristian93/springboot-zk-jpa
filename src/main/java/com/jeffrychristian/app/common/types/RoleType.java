package com.jeffrychristian.app.common.types;

/**
 * Created by jeffry.christian on 11/22/2016.
 */
public enum RoleType {

    ROLE_SUPER_ADMIN("Super Admin"),
    ROLE_ADMIN("Admin"),
    ROLE_USER("User");

    private String value;

    RoleType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}