package com.quangminh.jsonhibernate5.repository;

import com.quangminh.jsonhibernate5.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    @Transactional(readOnly = true)
    Optional<Author> findByName(String name);

    @Transactional(readOnly = true)
    @Query("SELECT a FROM Author a JOIN FETCH a.books WHERE a.name=?1")
    Author findByNameWithBooks(String name);
}