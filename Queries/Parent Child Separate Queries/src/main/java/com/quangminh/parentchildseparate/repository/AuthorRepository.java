package com.quangminh.parentchildseparate.repository;

import com.quangminh.parentchildseparate.entity.Author;
import com.quangminh.parentchildseparate.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface AuthorRepository extends JpaRepository<Author, Long> {
    @Query("SELECT a FROM Author a LEFT JOIN a.books b WHERE b = ?1")
    Author fetchByBooks(Book book);

    Author findByBooks(Book book);

}