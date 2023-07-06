package com.bk.quangminh.onetomanybidirectional.repository;

import com.bk.quangminh.onetomanybidirectional.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends JpaRepository<Book,Long> {

    @Query("select b from Book b left join Author a on b.author.id=a.id where a.name =:name")
    List<Book> findBooksByAuthor(@Param("name") String name);
}
