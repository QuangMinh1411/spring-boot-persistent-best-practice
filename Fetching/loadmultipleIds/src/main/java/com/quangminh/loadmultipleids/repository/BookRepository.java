package com.quangminh.loadmultipleids.repository;

import com.quangminh.loadmultipleids.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface BookRepository extends JpaRepository<Book,Long> {
    @Query("select b from Book b where b.id In ?1")
    List<Book> fetchByMultipleIds(List<Long> ids);
}
