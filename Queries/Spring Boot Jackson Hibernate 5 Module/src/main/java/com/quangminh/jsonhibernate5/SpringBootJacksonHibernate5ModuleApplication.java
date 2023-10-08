package com.quangminh.jsonhibernate5;

import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootJacksonHibernate5ModuleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootJacksonHibernate5ModuleApplication.class, args);
    }
//    @Bean
//    public Hibernate5Module hibernate5Module(){
//        return new Hibernate5Module();
//    }

}
