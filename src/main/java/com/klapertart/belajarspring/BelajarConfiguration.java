package com.klapertart.belajarspring;

import com.klapertart.belajarspring.model.*;
import com.klapertart.belajarspring.service.DatabaseConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.*;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import javax.validation.Validator;
import java.util.UUID;

/**
 * @author otongsunandar
 * @since 22/04/20
 */

@SpringBootApplication
// jika ng-load satu file properti
//@PropertySource("classpath:/properties/db.properties");

// jika ng-load lebih dari satu file properti
@PropertySources({
        @PropertySource("classpath:/properties/db.properties")
})
public class BelajarConfiguration {

    /* Ini Cara 1, Cara 2 dengan meng-inject langsung di class Author
    @Autowired
    private Environment environment;

    @Bean
    public Author createAuthor(){
        String user = environment.getProperty("author.user");
        String email = environment.getProperty("author.email");

        Author author = new Author(user,email);
        return author;
    }
    */

    // jika ada bean yang sama maka tambahkan "name" sebagai identifier
    // di method yang memanggil-nya tambahakn @Qualifier untuk memanggil method yang mana

    @Bean(name = "databean-1")
    // scope digunakan untuk jenis bean yang dihasilkan jika ada yang create
    // 1. secara default scope nya >> singleton, artinya jika ada yang create bean, maka
    // akan menghasilkan objek/bean yang sama, karena Spring akan membuatkan bean satu kali.
    // 2. jika scope nya >> prototype, artinya jika ada yang create bean, maka
    // akan menghasilkan objek/bean yang berbeda-beda.
    @Scope("prototype")
    public DataBean createDataBean(){
        String uuid = UUID.randomUUID().toString();
        DataBean bean = new DataBean(uuid);
        //DataBean bean = new DataBean("Otong");
        return bean;
    }

    @Bean(name = "databean-2")
    public DataBean createDataBean2(){
        String uuid = UUID.randomUUID().toString();
        DataBean bean = new DataBean(uuid);
        //DataBean bean = new DataBean("Sunandar");
        return bean;
    }

    @Bean
    public SampleBean createSampleBean(@Qualifier("databean-2") DataBean dataBean){
        SampleBean bean = new SampleBean(dataBean);
        return bean;
    }

    @Bean
    public OtherBean createOtherBean(@Qualifier("databean-1") DataBean dataBean, SampleBean sampleBean){
        OtherBean bean = new OtherBean(dataBean, sampleBean);
        return bean;
    }

    /*
    Method ini tidak perlu dibuat karena hanya me-return objek kelas
    tanpa ada kebutuhan inject dari kelas lain.

    Sebagai gantinya di class SayHello tambahkan notasi @Component
    agar bisa dideteksi Spring untuk dibuatkan bean-nya

    @Bean
    public SayHello createSayHello(){
        return new SayHello();
    }
     */

    @Bean
    @Profile("development")
    public DatabaseConfig createDevDatabaseConfig(){
        return new DatabaseConfig("DATABSE DEVELOPMENT");
    }

    @Bean
    @Profile("production")
    public DatabaseConfig createProdDatabaseConfig(){
        return new DatabaseConfig("DATABSE PRODUCTION");
    }

    @Bean(name = "messageSource")
    public MessageSource createMessageSource(){
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("messages.hello");
        return messageSource;
    }

    @Bean
    public Validator createValidator(){
        return new LocalValidatorFactoryBean();
    }
}
