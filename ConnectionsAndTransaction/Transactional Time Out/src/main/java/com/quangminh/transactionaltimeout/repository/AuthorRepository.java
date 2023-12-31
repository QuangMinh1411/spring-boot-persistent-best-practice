package com.quangminh.transactionaltimeout.repository;

import com.quangminh.transactionaltimeout.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    @QueryHints({
            // @QueryHint(name = "org.hibernate.timeout", value = "10"),             // Hibernate timeout in seconds
            // @QueryHint(name = "javax.persistence.query.timeout", value = "10000") // JPA timeout in milliseconds
    })
    @Query(value = "SELECT SLEEP(15)", nativeQuery = true)
    public void sleepQuery();
}