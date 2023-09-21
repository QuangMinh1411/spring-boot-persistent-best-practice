package com.quangminh.offsetpagination.repository;

import com.quangminh.offsetpagination.entity.Author;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    @Query("SELECT a FROM Author a WHERE a.genre = ?1")
    public Page<Author> fetchByGenre(String genre, Pageable pageable);

    @Query(value = "SELECT a FROM Author a WHERE a.genre = ?1",
            countQuery = "SELECT COUNT(*) FROM Author a WHERE a.genre = ?1")
    public Page<Author> fetchByGenreExplicitCount(String genre, Pageable pageable);

    @Query(value = "SELECT * FROM author WHERE genre = ?1",
            nativeQuery = true)
    public Page<Author> fetchByGenreNative(String genre, Pageable pageable);

    @Query(value = "SELECT * FROM author WHERE genre = ?1",
            countQuery = "SELECT COUNT(*) FROM author WHERE genre = ?1",
            nativeQuery = true)
    public Page<Author> fetchByGenreNativeExplicitCount(String genre, Pageable pageable);
}