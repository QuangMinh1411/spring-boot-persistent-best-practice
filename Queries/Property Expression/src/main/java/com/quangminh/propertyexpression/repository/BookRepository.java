package com.quangminh.propertyexpression.repository;

import com.quangminh.propertyexpression.dto.BookDto;
import com.quangminh.propertyexpression.entity.Author;
import com.quangminh.propertyexpression.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByAuthor(Author author);

    List<BookDto> queryByAuthor(Author author);

}