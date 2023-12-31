How To Use JPA Named Queries Via a Properties File

Description: JPA named (native) queries are commonly written via @NamedQuery and @NamedNativeQuery annotations in entity classes. Spring Data allows us to write our named (native) queries in a typical *.properties file inside the META-INF folder of your classpath. This way, we avoid modifying our entities. This application shows you how to do it.

Warning: Cannot use native queries with dynamic sorting (Sort). Nevertheless, using Sort in Pageable works fine. At least this is how it behave in Spring Boot 2.2.2.

Key points:

define the named (native) queries in a file, META-INF/jpa-named-queries.properties
follow the Spring {EntityName}.{RepositoryMethodName} naming convention for a quick and slim implementation


How To Use JPA Named Queries Via The orm.xml File

Description: JPA named (native) queries are commonly written via @NamedQuery and @NamedNativeQuery annotations in entity classes. Spring Data allows us to write our named (native) queries in a typical orm.xml file inside the META-INF folder of your classpath. This way, we avoid modifying our entities. This application shows you how to do it.

Warning: Pay attention that, via this approach, we cannot use named (native) queries with dynamic sorting (Sort). Using Sort in Pageable is ignored, therefore you need to explicitly add ORDER BY in the queries. At least this is how it behave in Spring Boot 2.2.2. A better approach relies on using a properties file for listing the named (native) queries. In this case, dynamic Sort works for named queries, but not for named native queries. Using Sort in Pageable works as expected in named (native) queries.

Key points:

define the named (native) queries in a file, META-INF/orm.xml
follow the Spring {EntityName}.{RepositoryMethodName} naming convention for a quick and slim implementation