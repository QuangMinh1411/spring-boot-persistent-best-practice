package com.quangminh.jpainheritancejoined.repository;

import com.quangminh.jpainheritancejoined.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    @Transactional(readOnly=true)
    Author findByName(String name);

    @Transactional(readOnly=true)
    @Query("SELECT a FROM Author a JOIN FETCH a.books b")
    public Author findAuthor();
}