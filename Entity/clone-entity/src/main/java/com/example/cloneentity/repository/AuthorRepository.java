package com.example.cloneentity.repository;

import com.example.cloneentity.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@Repository
public interface AuthorRepository extends JpaRepository<Author,Long> {
    @Query("select a from Author a join fetch a.books where a.name=?1")
    Author fetchByName(String name);
}
