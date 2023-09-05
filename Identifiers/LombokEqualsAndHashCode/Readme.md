Why To Avoid Lombok @EqualsAndHashCode And @Data In Entities And How To Override equals() And hashCode()

Description: Entities should implement equals() and hashCode() as here. The main idea is that Hibernate requires that an entity is equal to itself across all its state transitions (transient, attached, detached and removed). Using Lombok @EqualsAndHashCode (or @Data) will not respect this requirment.

Key points:
AVOID THESE APPROACHES

Using Lombok default behavior of @EqualsAndHashCode (entity: LombokDefaultBook, test: LombokDefaultEqualsAndHashCodeTest)
Using Lombok @EqualsAndHashCode with primary key only (entity: LombokIdBook, test: LombokEqualsAndHashCodeWithIdOnlyTest)
Rely on default equals() and hashCode() (entity: DefaultBook, test: DefaultEqualsAndHashCodeTest)
Rely on default equals() and hashCode() containing only the database-generated identifier (entity: IdBook, test: IdEqualsAndHashCodeTest)
PREFER THESE APPROACHES

Rely on business key (entity: BusinessKeyBook, test: BusinessKeyEqualsAndHashCodeTest)
Rely on @NaturalId (entity: NaturalIdBook, test: NaturalIdEqualsAndHashCodeTest)
Rely on manually assigned identifiers (entity: IdManBook, test: IdManEqualsAndHashCodeTest)
Rely on database-generated identifiers (entity: IdGenBook, test: IdGenEqualsAndHashCodeTest)