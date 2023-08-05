package com.quangminh.joinfetch.repository;

import com.quangminh.joinfetch.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    @Transactional(readOnly = true)
    @Query("select a FROM Author a JOIN FETCH a.books WHERE a.name=?1")
    Author fetchAuthorWithBooksByName(String name);
    @Transactional(readOnly = true)
    @Query("select a,b from Author a inner join a.books b where b.price>?1")
    List<Author> fetchAuthorsBooksByPriceInnerJoin(int price);
    @Transactional(readOnly = true)
    @Query("select a from Author a join fetch a.books b where b.price>?1")
    List<Author> fetchAuthorsBooksByPriceJoinFetch(int price);
}