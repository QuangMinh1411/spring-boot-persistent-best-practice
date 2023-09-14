How To Setup Spring Data JPA Auditing

If you prefer to read it as a blog-post containing the relevant snippets of code then check this post

Description: Auditing is useful for maintaining history records. This can later help us in tracking user activities.

Key points:

create an abstract base entity (e.g., BaseEntity) and annotate it with @MappedSuperclass and @EntityListeners({AuditingEntityListener.class})
in this base entity, add the following fields that will be automatically persisted:
- @CreatedDate protected LocalDateTime created;
- @LastModifiedDate protected LocalDateTime lastModified;
- @CreatedBy protected U createdBy;
- @LastModifiedBy protected U lastModifiedBy;
enable auditing via @EnableJpaAuditing(auditorAwareRef = "auditorAware")
provide an implementation for AuditorAware (this is needed for persisting the user that performed the modification; use Spring Security to return the currently logged-in user)
expose this implementation via @Bean
entites that should be audited should extend the base entity
store the date-time in database in UTC