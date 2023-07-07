package com.example.cascadechildremoval.repository;


import com.example.cascadechildremoval.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
public interface AuthorRepository extends JpaRepository<Author,Long> {
    Author findByName(String name);

    List<Author> findByAge(int age);
    @Query("select a from Author a join fetch a.books where a.name = ?1")
    Author findByNameWithBooks(String name);
    @Query("select a from Author a join fetch a.books where a.genre=?1")
    List<Author> findByGenreWithBooks(String genre);

    @Transactional
    @Modifying(flushAutomatically = true,clearAutomatically = true)
    @Query("delete from Author a where a.id=?1")
    public int deleteByIdentifier(Long id);
    @Transactional
    @Modifying(flushAutomatically = true,clearAutomatically = true)
    @Query("delete from Author a where a.id in ?1")
    public int deleteBulkByIdentifier(List<Long> id);
}
