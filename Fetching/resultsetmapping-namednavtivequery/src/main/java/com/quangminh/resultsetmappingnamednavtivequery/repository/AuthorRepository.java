package com.quangminh.resultsetmappingnamednavtivequery.repository;

import com.quangminh.resultsetmappingnamednavtivequery.dto.AuthorDto;
import com.quangminh.resultsetmappingnamednavtivequery.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author,Long> {
    @Query(name = "AuthorQuery", nativeQuery = true)
    List<Author> fetchAll();

    @Query(name="AuthorWithBookQuery",nativeQuery = true)
    List<AuthorDto> fetchAuthorWithBook();
}
