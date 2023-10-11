package com.quangminh.storeprocedure.repository;

import com.quangminh.storeprocedure.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    @Transactional
    @Procedure(name = "CountByGenreProcedure")
    Integer countByGenre(@Param("p_genre") String genre);
}