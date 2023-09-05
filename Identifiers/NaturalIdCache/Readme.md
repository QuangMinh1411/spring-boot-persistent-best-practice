How To Use Hibernate @NaturalIdCache For Skipping The Entity Identifier Retrieval

Description: This is a SpringBoot - MySQL application that maps a natural business key using Hibernate @NaturalId. This implementation allows us to use @NaturalId as it was provided by Spring. Moreover, this application uses Second Level Cache (EhCache) and @NaturalIdCache for skipping the entity identifier retrieval from the database.

Key points:

enable Second Level Cache (EhCache)
annotate entity with @NaturalIdCache for caching natural ids
optionally, annotate entity with @Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "Book") for caching entites as well