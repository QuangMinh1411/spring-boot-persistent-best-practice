package com.example.cascadechildremoval.repository;

import com.example.cascadechildremoval.entity.Author;
import com.example.cascadechildremoval.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
public interface BookRepository extends JpaRepository<Book,Long> {
    Book findByTitle(String title);
    @Transactional
    @Modifying(flushAutomatically = true,clearAutomatically = true)
    @Query("delete from Book b where b.author.id=?1")
    public int deleteByAuthorIdentifier(Long id);

    @Transactional
    @Modifying(flushAutomatically = true,clearAutomatically = true)
    @Query("delete from Book b where b.author.id in ?1")
    public int deleteBulkByAuthorIdentifier(List<Long> id);

    @Transactional
    @Modifying(flushAutomatically = true,clearAutomatically = true)
    @Query("delete from Book b where b.author in ?1")
    public int deleteBulkByAuthors(List<Author> authors);
}
