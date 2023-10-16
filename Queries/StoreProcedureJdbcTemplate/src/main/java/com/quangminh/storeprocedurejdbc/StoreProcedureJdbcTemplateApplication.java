package com.quangminh.storeprocedurejdbc;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.CompositeDatabasePopulator;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.jdbc.datasource.init.ScriptUtils;

@SpringBootApplication
public class StoreProcedureJdbcTemplateApplication {

//    @Bean
//    public ApplicationRunner init() {
//        return args -> {
//            var resource = new ResourceDatabasePopulator(new ClassPathResource("schema.sql"));
//            resource.setSeparator(ScriptUtils.EOF_STATEMENT_SEPARATOR);
//            var populator = new CompositeDatabasePopulator();
//            populator.addPopulators(resource);
//        };
//    }
    public static void main(String[] args) {
        SpringApplication.run(StoreProcedureJdbcTemplateApplication.class, args);
    }

}
