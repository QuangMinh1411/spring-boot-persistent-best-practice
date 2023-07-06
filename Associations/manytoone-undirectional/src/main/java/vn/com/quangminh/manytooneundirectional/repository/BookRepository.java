package vn.com.quangminh.manytooneundirectional.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.com.quangminh.manytooneundirectional.entity.Book;

import java.util.List;

public interface BookRepository extends JpaRepository<Book,Long> {
    @Query("select b from Book b where b.author.id = :id")
    List<Book> fetchBoosOfAuthorityById(@Param("id") Long id);

    @Query("select b from Book b where b.author.id =:id")
    Page<Book> fetchPageBooksOfAuthorById(@Param("id") Long id, Pageable pageable);
}
