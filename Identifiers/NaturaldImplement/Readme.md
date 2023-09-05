How To Use Hibernate @NaturalId In Spring Boot Style

Description: This is a SpringBoot application that maps a natural business key using Hibernate @NaturalId. This implementation allows us to use @NaturalId as it was provided by Spring.

Key points:

in the entity (e.g., Book), mark the properties (business keys) that should act as natural IDs with @NaturalId; commonly, there is a single such property, but multiple are suppored as well as here
for non-mutable ids, mark the columns as @NaturalId(mutable = false) and @Column(nullable = false, updatable = false, unique = true, ...)
for mutable ids, mark the columns as @NaturalId(mutable = true) and @Column(nullable = false, updatable = true, unique = true, ...)
override the equals() and hashCode() using the natural id(s)
define a @NoRepositoryBean interface (NaturalRepository) to define two methods, named findBySimpleNaturalId() and findByNaturalId()
provide an implementation for this interface (NaturalRepositoryImpl) relying on Hibernate, Session, bySimpleNaturalId() and byNaturalId() methods
use @EnableJpaRepositories(repositoryBaseClass = NaturalRepositoryImpl.class) to register this implementation as the base class
for the entity, write a classic repository
inject this class in your services and call findBySimpleNaturalId() or findByNaturalId()