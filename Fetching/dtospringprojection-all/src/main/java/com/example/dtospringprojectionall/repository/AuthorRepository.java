package com.example.dtospringprojectionall.repository;

import com.example.dtospringprojectionall.entity.Author;
import com.example.dtospringprojectionall.projection.AuthorNameAge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface AuthorRepository extends JpaRepository<Author,Long> {
    @Transactional(readOnly = true)
    @Query("select new com.example.dtospringprojectionall.projection.AuthorNameAge(name,age) from Author a where a.genre=?1")
    List<AuthorNameAge> findFirst2ByGenre(String genre);
}
