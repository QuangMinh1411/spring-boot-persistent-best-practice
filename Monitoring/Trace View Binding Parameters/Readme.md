How To View Binding Params Via TRACE

Description: View the prepared statement binding/extracted parameters via TRACE.

Key points:

in application.properties add: logging.level.org.hibernate.type.descriptor.sql=TRACE
or, even better (for filtering SQLs capabilities), in a Logback specific configuration file add the proper logger