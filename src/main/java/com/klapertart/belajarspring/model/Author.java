package com.klapertart.belajarspring.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author otongsunandar
 * @since 28/04/20
 */
@Component("author")
public class Author {
    private String user;
    private String email;

    @Autowired
    public Author(@Value("${author.user}") String user, @Value("${author.email}") String email) {
        this.user = user;
        this.email = email;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
