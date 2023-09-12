How To Customize HikariCP Settings Via Properties

If you use the spring-boot-starter-jdbc or spring-boot-starter-data-jpa "starters", you automatically get a dependency to HikariCP

Note: The best way to tune the connection pool parameters consist in using Flexy Pool by Vlad Mihalcea. Via Flexy Pool you can find the optim settings that sustain high-performance of your connection pool.

Description: This is a kickoff application that set up HikariCP via application.properties only. The jdbcUrl is set up for a MySQL database. For testing purposes, the application uses an ExecutorServicefor simulating concurrent users. Check the HickariCP report revealing the connection pool status.

Key points:

in application.properties, rely on spring.datasource.hikari.* to configure HikariCP