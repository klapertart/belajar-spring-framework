package com.klapertart.belajarspring.model;

/**
 * @author otongsunandar
 * @since 22/04/20
 */
public class DataBean {
    private String value;

    public DataBean(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
