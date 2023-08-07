package com.minhquang.unrelatedentities.repository;

import com.minhquang.unrelatedentities.dto.BookstoreDto;
import com.minhquang.unrelatedentities.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    @Transactional(readOnly = true)
    @Query(value = "SELECT a.name AS name, b.title AS title "
            + "FROM Author a INNER JOIN Book b ON a.name = b.name "
            + "WHERE b.price = ?1")
    List<BookstoreDto> fetchAuthorNameBookTitleWithPrice(int price);
}