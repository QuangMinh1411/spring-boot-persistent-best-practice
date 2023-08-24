package com.quangminh.transactionalrepository.repository;

import com.quangminh.transactionalrepository.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface AuthorRepository extends JpaRepository<Author, Long> {
    @Query("SELECT a FROM Author a WHERE a.name = ?1")
    public Author fetchByName(String name);

    @Transactional
    @Modifying
    @Query("DELETE FROM Author a WHERE a.genre <> ?1")
    public int deleteByNeGenre(String genre);
}