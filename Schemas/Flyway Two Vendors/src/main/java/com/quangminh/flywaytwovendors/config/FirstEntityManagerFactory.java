package com.quangminh.flywaytwovendors.config;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableJpaRepositories(
        entityManagerFactoryRef = "ds1EntityManagerFactory",
        transactionManagerRef = "ds1TransactionManager",
        basePackages = "com.quangminh.flywaytwovendors.ds1"
)
@EnableTransactionManagement
public class FirstEntityManagerFactory {
    @Bean
    @Primary
    public LocalContainerEntityManagerFactoryBean ds1EntityManagerFactory(
            EntityManagerFactoryBuilder builder, @Qualifier("dataSourceMySql") DataSource dataSource) {

        return builder
                .dataSource(dataSource)
                .packages(packagesToScan())
                .persistenceUnit("ds1-pu")
                .properties(hibernateProperties())
                .build();
    }

    @Bean
    @Primary
    public PlatformTransactionManager ds1TransactionManager(
            @Qualifier("ds1EntityManagerFactory") EntityManagerFactory ds1EntityManagerFactory) {
        return new JpaTransactionManager(ds1EntityManagerFactory);
    }

    protected String[] packagesToScan() {
        return new String[]{
                "com.quangminh.flywaytwovendors.ds1"
        };
    }

    protected Map<String, String> hibernateProperties() {
        return new HashMap<String, String>() {
            {
                put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
            }
        };
    }
}
