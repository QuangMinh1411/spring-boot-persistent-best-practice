How To Extract Tables Metadata

Description: This application is an example of using the Hibernate SPI, org.hibernate.integrator.spi.Integrator for extracting tables metadata.

Key points:

implement org.hibernate.integrator.spi.Integrator and override integrate() method to return metadata.getDatabase()
register this Integrator via LocalContainerEntityManagerFactoryBean