package com.quangminh.softdelete.repository;

import com.quangminh.softdelete.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    @Query(value = "SELECT * FROM book", nativeQuery = true)
    List<Book> findAllIncludingDeleted();

    @Query(value = "SELECT * FROM book AS b WHERE b.deleted = true", nativeQuery = true)
    List<Book> findAllOnlyDeleted();

    @Transactional
    @Query(value = "UPDATE Book b SET b.deleted = false WHERE b.author_id = ?1",nativeQuery = true)
    @Modifying
    public void restoreByAuthorId(Long id);

    @Transactional
    @Query(value = "UPDATE Book b SET b.deleted = false WHERE b.id = ?1",nativeQuery = true)
    @Modifying
    public void restoreById(Long id);
}