package com.quangminh.bulkupdate.repository;

import com.quangminh.bulkupdate.entiity.Author;
import com.quangminh.bulkupdate.entiity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    @Transactional
    @Modifying(flushAutomatically = true,clearAutomatically = true)
    @Query("update Book b SET b.isbn='none',b.version=b.version+1")
    public short updateInBulk();

    @Transactional
    @Modifying(flushAutomatically = true,clearAutomatically = true)
    @Query("update Book b set b.isbn='none',b.version=b.version+1 " +
            "where b.author in ?1")
    public int updateInBulk(List<Author> authors);
}