How To Avoid Lazy Initialization Issues Caused By Disabling Open Session In View Via Hibernate5Module

Note: Hibernate5Module is an add-on module for Jackson JSON processor which handles Hibernate datatypes; and specifically aspects of lazy-loading.

Description: By default, in Spring Boot, the Open Session in View anti-pattern is enabled. Now, imagine a lazy relationship (e.g., @OneToMany) between two entities, Author and Book (an author has associated more books). Next, a REST controller endpoint fetches an Author without the associated Book. But, the View (more precisely, Jackson), forces the lazy loading of the associated Book as well. Since OSIV will supply the already opened Session, the Proxy initializations take place successfully.

Of course, the correct decision is to disable OSIV by setting it to false, but this will not stop Jackson to try to force the lazy initialization of the associated Book entities. Running the code again will result in an exception of type: Could not write JSON: failed to lazily initialize a collection of role: com.bookstore.entity.Author.books, could not initialize proxy - no Session; nested exception is com.fasterxml.jackson.databind.JsonMappingException: failed to lazily initialize a collection of role: com.bookstore.entity.Author.books, could not initialize proxy - no Session.

Well, among the Hibernate5Module features we have support for dealing with this aspect of lazy loading and eliminate this exception. Even if OSIV will continue to be enabled (not recommended), Jackson will not use the Session opened via OSIV.

Key points:

for Maven, add the Hibernate5Module dependency in pom.xml
add a @Bean that returns an instance of Hibernate5Module
annotate the Author bean with @JsonInclude(Include.NON_EMPTY) to exclude null or what is considered empty from the returned JSON
Note: The presence of Hibernate5Module instructs Jackson to initialize the lazy associations with default values (e.g., a lazy associated collection will be initialized with null). Hibernate5Module doesn't work for lazy loaded attributes. For such case consider this item.

Note: Before reading this item try to see if Hibernate5Module is not what you are looking for.

Description: The Open-Session in View anti-pattern is activated by default in SpringBoot. Now, imagine a lazy association (e.g., @OneToMany) between two entities, Author and Book (an author has associated more books). Next, a REST controller endpoint fetches an Author without the associated Book. But, the View (more precisely, Jackson), forces the lazy loading of the associated Book as well. Since OSIV will supply the already opened Session, the proxies initializations take place successfully. The solution to avoid this performance penalty starts by disabling the OSIV. Further, explicitly initialize the un-fetched lazy associations. This way, the View will not force lazy loading.

Key points:

disable OSIV by adding in application.properties this setting: spring.jpa.open-in-view=false
fetch an Author entity and initialize its associated Book explicitly with (default) values (e.g., null)
set @JsonInclude(Include.NON_EMPTY) on this entity-level to avoid rendering null or what is considered empty in the resulted JSON
NOTE: If OSIV is enabled, the developer can still initialize the un-fetched lazy associations manually as long as he does this outside of a transaction to avoid flushing. But, why is this working? Since the Session is open, why the manually initialization of the associations of a managed entity doesn't trigger the flush? The answer can be found in the documentation of OpenSessionInViewFilter which specifies that: This filter will by default not flush the Hibernate Session, with the flush mode set to FlushMode.NEVER. It assumes to be used in combination with service layer transactions that care for the flushing: The active transaction manager will temporarily change the flush mode to FlushMode.AUTO during a read-write transaction, with the flush mode reset to FlushMode.NEVER at the end of each transaction. If you intend to use this filter without transactions, consider changing the default flush mode (through the "flushMode" property).\

Why To Avoid Hibernate-specific hibernate.enable_lazy_load_no_trans

Description: This application is an example of using Hibernate-specific hibernate.enable_lazy_load_no_trans. Check out the application log to see how transactions and database connections are used.

Key points:

always avoid Hibernate-specific hibernate.enable_lazy_load_no_trans