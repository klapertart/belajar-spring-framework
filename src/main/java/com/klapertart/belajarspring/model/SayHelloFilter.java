package com.klapertart.belajarspring.model;

import org.springframework.stereotype.Component;

/**
 * @author otongsunandar
 * @since 23/04/20
 */
@Component
public class SayHelloFilter {
    public String filter(String value){
        return value.toUpperCase();
    }
}
