How To Retry Transaction After OptimisticLockException Exception (Hibernate Version-less Optimistic Locking Mechanism)

Note: Optimistic locking mechanism via Hibernate version-less doesn't work for detached entities (don't close the Persistent Context).

Description: This is a Spring Boot application that simulates a scenario that leads to an optimistic locking exception (e.g., in Spring Boot, OptimisticLockingFailureException) via Hibernate version-less optimistic locking. When such exception occur, the application retry the corresponding transaction via db-util library developed by Vlad Mihalcea.

Key points:

for Maven, in pom.xml, add the db-util library dependency
configure the OptimisticConcurrencyControlAspect bean
annotate the corresponding entity (e.g., Inventory) with @DynamicUpdate and @OptimisticLocking(type = OptimisticLockType.DIRTY)
mark the method (not annotated with @Transactional) that is prone to throw (or that calls a method that is prone to throw (this method can be annotated with @Transactional)) an optimistic locking exception with @Retry(times = 10, on = OptimisticLockingFailureException.class)


How To Retry Transaction Via TransactionTemplate After OptimisticLockException Shaped Via Hibernate Version-less Optimistic Locking Mechanism

Note: Version-less optimistic locking doesn't work for detached entities (do not close the Persistence Context).

Description: This is a Spring Boot application that simulates a scenario that leads to an optimistic locking exception. When such exception occur, the application retry the corresponding transaction via db-util library developed by Vlad Mihalcea.

Key points:

for Maven, in pom.xml, add the db-util dependency
configure the OptimisticConcurrencyControlAspect bean
rely on TransactionTemplate