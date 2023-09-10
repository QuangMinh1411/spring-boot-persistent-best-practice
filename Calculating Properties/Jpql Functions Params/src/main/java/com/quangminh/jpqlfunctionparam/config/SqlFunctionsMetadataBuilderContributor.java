package com.quangminh.jpqlfunctionparam.config;
import org.hibernate.boot.MetadataBuilder;
import org.hibernate.boot.spi.MetadataBuilderContributor;

import org.hibernate.dialect.function.StandardSQLFunction;

import org.hibernate.type.StandardBasicTypes;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SqlFunctionsMetadataBuilderContributor implements MetadataBuilderContributor {


    @Override
    public void contribute(MetadataBuilder metadataBuilder) {
        metadataBuilder.applySqlFunction(
               "concat_ws",
                new StandardSQLFunction(
                        "concat_ws",
                        StandardBasicTypes.STRING
                )
        );
    }
}
