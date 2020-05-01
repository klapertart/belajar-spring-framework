package com.klapertart.belajarspring.service;

/**
 * @author otongsunandar
 * @since 25/04/20
 */
public class DatabaseConfig {
    private  String value;

    public DatabaseConfig(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
