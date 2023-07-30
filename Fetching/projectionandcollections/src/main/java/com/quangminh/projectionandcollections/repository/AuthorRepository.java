package com.quangminh.projectionandcollections.repository;

import com.quangminh.projectionandcollections.dto.AuthorDto;
import com.quangminh.projectionandcollections.dto.SimpleAuthorDto;
import com.quangminh.projectionandcollections.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Set;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    List<AuthorDto> findBy();

    @Query("select a.name as name,a.genre as genre,b as books from Author a inner join a.books b")
    List<AuthorDto> findByViaQuery();
    @Query("select a from Author a join fetch a.books")
    Set<AuthorDto> findByJoinFetch();
    @Query("select a.name as name,a.genre as genre,b.title as title from Author a inner join a.books b")
    List<SimpleAuthorDto> findByViaQuerySimpleDto();

    @Query("select a.name as name,a.genre as genre,b.title as title from Author a inner join a.books b")
    List<Object[]> findByViaArrayOfObjects();
    @Query("select a.id as authorId,a.name as name,a.genre as genre,b.id as bookId,b.title as title from Author a inner join a.books b")
    List<Object[]> findByViaArrayOfObjectsWithIds();

}