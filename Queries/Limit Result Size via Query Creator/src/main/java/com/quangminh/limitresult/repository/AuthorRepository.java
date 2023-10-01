package com.quangminh.limitresult.repository;

import com.quangminh.limitresult.dto.AuthorDto;
import com.quangminh.limitresult.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
public interface AuthorRepository extends JpaRepository<Author, Long> {
    List<Author> findFirst5By();

    List<Author> findFirst5ByAge(int age);

    List<Author> findFirst5ByAgeGreaterThanEqual(int age);

    List<Author> findFirst5ByAgeLessThan(int age);

    List<Author> findFirst5ByAgeOrderByNameDesc(int age);

    List<Author> findFirst5ByGenreOrderByAgeAsc(String genre);

    List<Author> findFirst5ByAgeGreaterThanEqualOrderByNameAsc(int age);

    List<Author> findFirst5ByGenreAndAgeLessThanOrderByNameDesc(String genre, int age);

    List<AuthorDto> findFirst5ByOrderByAgeAsc();
}