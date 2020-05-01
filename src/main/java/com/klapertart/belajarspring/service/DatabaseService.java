package com.klapertart.belajarspring.service;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author otongsunandar
 * @since 23/04/20
 */
@Component
public class DatabaseService {

    // Anotasi PostContract artinya method tersebut akan dieksekusi oleh Spring setelah
    // Spring melakukan inisialisasi bean DatabaseService.
    @PostConstruct
    public void openConnection(){
        System.out.println("Membuka koneksi database!");
    }

    // Anotasi PreDestroy artinya method tersebut akan dieksekusi sebelum
    // aplikasi ditutup oleh Spring jika Scope-nya Singleton, jika
    // Scope-nya Prototype maka tidak akan dieksekusi oleh Spring
    @PreDestroy
    public void closeConnection(){
        System.out.println("Menutup koneksi database!");
    }
}
