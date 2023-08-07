package com.minhquang.streammysql.repository;

import com.minhquang.streammysql.entity.Author;
import jakarta.persistence.QueryHint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.util.Streamable;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Stream;

import static org.hibernate.jpa.HibernateHints.HINT_FETCH_SIZE;
@Transactional(readOnly = true)
public interface AuthorRepository extends JpaRepository<Author, Long> {
    @Query("select a from Author a")
    @QueryHints(value = @QueryHint(name = HINT_FETCH_SIZE,value = ""+ Integer.MIN_VALUE))
    Stream<Author> streamAll();

    Streamable<Author> findByGenre(String genre);
    Streamable<Author> queryByGenre(String genre);
    Streamable<Author> findByAgeGreaterThan(int age);
    Streamable<Author> findByGenreAndAgeGreaterThan(String genre,int age);
    Streamable<Author> findByGenreOrAgeGreaterThan(String genre,int age);
    Streamable<Author> findBy();

}