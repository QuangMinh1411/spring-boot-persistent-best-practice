package com.example.twodatasource.config;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableJpaRepositories(
        entityManagerFactoryRef = "ds2EntityManagerFactory",
        transactionManagerRef = "ds2TransactionManager",
        basePackages = "com.example.twodatasource.ds2"
)
@EnableTransactionManagement
public class SecondEntityManagerFactory {

    @Bean
    public LocalContainerEntityManagerFactoryBean ds2EntityManagerFactory(
            EntityManagerFactoryBuilder builder, @Qualifier("dataSourceBooksDb") DataSource dataSource) {

        return builder
                .dataSource(dataSource)
                .packages(packagesToScan())
                .persistenceUnit("ds2-pu")
                .properties(hibernateProperties())
                .build();
    }

    @Bean
    public PlatformTransactionManager ds2TransactionManager(
            @Qualifier("ds2EntityManagerFactory") EntityManagerFactory secondEntityManagerFactory) {
        return new JpaTransactionManager(secondEntityManagerFactory);
    }

    protected String[] packagesToScan() {
        return new String[]{
                "com.example.twodatasource.ds2"
        };
    }

    protected Map<String, String> hibernateProperties() {
        return new HashMap<String, String>() {
            {
                put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
                put("hibernate.hbm2ddl.auto", "create");
            }
        };
    }
}
