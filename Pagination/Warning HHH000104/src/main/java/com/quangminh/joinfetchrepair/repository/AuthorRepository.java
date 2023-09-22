package com.quangminh.joinfetchrepair.repository;

import com.quangminh.joinfetchrepair.entity.Author;
import jakarta.persistence.QueryHint;
import jakarta.persistence.Tuple;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface AuthorRepository extends JpaRepository<Author, Long> {
    @Transactional(readOnly = true)
    @Query(value = "SELECT a.id FROM Author a WHERE a.genre = ?1")
    Page<Long> fetchPageOfIdsByGenre(String genre, Pageable pageable);

    @Transactional(readOnly = true)
    @Query(value = "SELECT a.id AS id, COUNT(*) OVER() AS total FROM Author a WHERE a.genre = ?1",
            nativeQuery = true)
    List<Tuple> fetchTupleOfIdsByGenre(String genre, Pageable pageable);

    @Transactional(readOnly = true)
    @Query(value = "SELECT a.id FROM Author a WHERE a.genre = ?1")
    Slice<Long> fetchSliceOfIdsByGenre(String genre, Pageable pageable);

    @Transactional(readOnly = true)
    @Query(value = "SELECT a.id FROM Author a WHERE a.genre = ?1")
    List<Long> fetchListOfIdsByGenre(String genre, Pageable pageable);

    @Transactional(readOnly = true)
    @Query(value = "SELECT DISTINCT a FROM Author a LEFT JOIN FETCH a.books WHERE a.id IN ?1")
    List<Author> fetchWithBooksJoinFetch(List<Long> authorIds);

    @Transactional(readOnly = true)
    @EntityGraph(attributePaths = {"books"}, type = EntityGraph.EntityGraphType.FETCH)
    @Query(value = "SELECT DISTINCT a FROM Author a WHERE a.id IN ?1")
    List<Author> fetchWithBooksEntityGraph(List<Long> authorIds);
}