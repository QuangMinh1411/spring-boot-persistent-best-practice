package com.quangminh.propertyexpression.repository;

import com.quangminh.propertyexpression.dto.AuthorDto;
import com.quangminh.propertyexpression.entity.Author;
import com.quangminh.propertyexpression.entity.Book;
import com.quangminh.propertyexpression.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface AuthorRepository extends JpaRepository<Author, Long> {
    Author findByBooks(Book book);

    Author findByBooksReviews(Review review);

    AuthorDto queryByBooks(Book book);

    AuthorDto queryByBooksReviews(Review review);

}