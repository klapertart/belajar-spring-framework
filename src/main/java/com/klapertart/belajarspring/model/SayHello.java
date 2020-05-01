package com.klapertart.belajarspring.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.stereotype.Component;

import java.util.Locale;

/**
 * @author otongsunandar
 * @since 23/04/20
 */

// @Component ditambahkan untuk configurasi yang terpisah
// dari kelas konfigurasi utama (BelajarConfiguration)

@Component
public class SayHello implements MessageSourceAware {
    private SayHelloFilter filter;

    private MessageSource messageSource;

    // anotasi @Autowired digunakan untuk meng-inject kelas lain
    // di class beranotasi @Component
    // bisa diletakan di constructor ato method
    @Autowired
    public SayHello(SayHelloFilter filter) {
        this.filter = filter;
    }

    public String hello(String name){
        //return ("Hello " + filter.filter(name));
        return (messageSource.getMessage("hello",new Object[]{filter.filter(name)}, Locale.getDefault()));
    }

    @Override
    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }
}
