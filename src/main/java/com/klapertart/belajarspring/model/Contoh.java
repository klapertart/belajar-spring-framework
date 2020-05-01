package com.klapertart.belajarspring.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author otongsunandar
 * @since 01/05/20
 */
@Component
public class Contoh {
    private String authorName;
    private int nilai;

    // (1) nilai authorName ini akan diambil dari property name class Author
    // syaratnya, component class Author harus diberinama

    // (2) nilai authorName ini akan diambil dari method getUser class Author

    @Autowired
    public Contoh(@Value("#{ author.getUser() }") String authorName, @Value("#{ 6*9}") int nilai) {
        this.authorName = authorName;
        this.nilai = nilai;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public int getNilai() {
        return nilai;
    }

    public void setNilai(int nilai) {
        this.nilai = nilai;
    }
}
