package com.quangminh.dtoentityviaprojection.repository;

import com.quangminh.dtoentityviaprojection.dto.BookstoreDto;
import com.quangminh.dtoentityviaprojection.entity.Author;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    @Query("select a as author,b.title as title from Author a join a.books b")
    List<BookstoreDto> fetchAllPaging(Pageable pageable);

    @Query("select a as author,b.title as title from Author a join a.books b")
    List<BookstoreDto> fetchAll();
}