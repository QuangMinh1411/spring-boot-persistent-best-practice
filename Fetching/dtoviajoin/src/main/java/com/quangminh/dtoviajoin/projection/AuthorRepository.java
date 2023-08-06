package com.quangminh.dtoviajoin.projection;

import com.quangminh.dtoviajoin.repository.AuthorNameBookTitle;
import com.quangminh.dtoviajoin.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
public interface AuthorRepository extends JpaRepository<Author, Long> {
    // Fetch authors and books (JPQL)
    @Query(value = "SELECT b.title AS title, a.name AS name "
            + "FROM Author a INNER JOIN a.books b")
    List<AuthorNameBookTitle> findAuthorsAndBooksJpql();

    // Fetch authors and books (SQL)
    @Query(value = "SELECT b.title AS title, a.name AS name "
            + "FROM author a INNER JOIN book b ON a.id = b.author_id",
            nativeQuery = true)
    List<AuthorNameBookTitle> findAuthorsAndBooksSql();

    // Fetch authors and books filtering by author's genre and book's price (JPQL)
    @Query(value = "SELECT b.title AS title, a.name AS name "
            + "FROM Author a INNER JOIN a.books b WHERE a.genre = ?1 AND b.price < ?2")
    List<AuthorNameBookTitle> findAuthorsAndBooksByGenreAndPriceJpql(String genre, int price);

    // Fetch authors and books filtering by author's genre and book's price (SQL)
    @Query(value = "SELECT b.title AS title, a.name AS name "
            + "FROM author a INNER JOIN book b ON a.id = b.author_id WHERE a.genre = ?1 AND b.price < ?2",
            nativeQuery = true)
    List<AuthorNameBookTitle> findAuthorsAndBooksByGenreAndPriceSql(String genre, int price);


    // Fetch authors and books including authors that have no registered book (JPQL)
    @Query(value = "SELECT b.title AS title, a.name AS name "
            + "FROM Author a LEFT JOIN a.books b")
    List<AuthorNameBookTitle> findAuthorsAndBooksJpqlLeftJoin();

    // Fetch authors and books including authors that have no registered book (SQL)
    @Query(value = "SELECT b.title AS title, a.name AS name "
            + "FROM author a LEFT JOIN book b ON a.id = b.author_id",
            nativeQuery = true)
    List<AuthorNameBookTitle> findAuthorsAndBooksSqlLeftJoin();

    // Fetch authors and books excluding authors that have registered books (JPQL)
    @Query(value = "SELECT b.title AS title, a.name AS name "
            + "FROM Author a LEFT JOIN a.books b WHERE b.id IS NULL")
    List<AuthorNameBookTitle> findAuthorsAndBooksJpqlLeftJoinExcluding();

    // Fetch authors and books excluding authors that have registered books (SQL)
    @Query(value = "SELECT b.title AS title, a.name AS name "
            + "FROM author a LEFT JOIN book b ON a.id = b.author_id WHERE b.id IS NULL",
            nativeQuery = true)
    List<AuthorNameBookTitle> findAuthorsAndBooksSqlLeftJoinExcluding();
}