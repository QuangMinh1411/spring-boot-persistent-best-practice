package com.quangminh.joinformual.repository;

import com.quangminh.joinformual.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    @Query("select b from Book b where b.author.id=?1")
    List<Book> getBooksByAuthorId(Long id);
}