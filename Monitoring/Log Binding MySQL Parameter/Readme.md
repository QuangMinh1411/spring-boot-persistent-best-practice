How To View Binding Params Via profileSQL=true In MySQL

Description: View the prepared statement binding parameters via profileSQL=true in MySQL.

Key points:

in application.properties append logger=Slf4JLogger&profileSQL=true to the JDBC URL (e.g., jdbc:mysql://localhost:3306/bookstoredb?createDatabaseIfNotExist=true&logger=Slf4JLogger&profileSQL=true)