package com.quangminh.dtoviajoin.repository;

import com.quangminh.dtoviajoin.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional(readOnly = true)
public interface BookRepository extends JpaRepository<Book, Long> {
    // Fetch books and authors (JPQL)
    @Query(value = "SELECT b.title AS title, a.name AS name "
            + "FROM Book b INNER JOIN b.author a")
    List<AuthorNameBookTitle> findBooksAndAuthorsJpql();

    // Fetch books and authors (SQL)
    @Query(value = "SELECT b.title AS title, a.name AS name "
            + "FROM book b INNER JOIN author a ON a.id = b.author_id",
            nativeQuery = true)
    List<AuthorNameBookTitle> findBooksAndAuthorsSql();

    // Fetch books and authors filtering by author's genre and book's price (JPQL)
    @Query(value = "SELECT b.title AS title, a.name AS name "
            + "FROM Book b INNER JOIN b.author a WHERE a.genre = ?1 AND b.price < ?2")
    List<AuthorNameBookTitle> findBooksAndAuthorsByGenreAndPriceJpql(String genre, int price);

    // Fetch books and authors filtering by author's genre and book's price (SQL)
    @Query(value = "SELECT b.title AS title, a.name AS name "
            + "FROM book b INNER JOIN author a ON a.id = b.author_id WHERE a.genre = ?1 AND b.price < ?2",
            nativeQuery = true)
    List<AuthorNameBookTitle> findBooksAndAuthorsByGenreAndPriceSql(String genre, int price);

    // Fetch books and authors including books that have no registered author (JPQL)
    @Query(value = "SELECT b.title AS title, a.name AS name "
            + "FROM Book b LEFT JOIN b.author a")
    List<AuthorNameBookTitle> findBooksAndAuthorsJpqlLeftJoin();

    // Fetch books and authors including books that have no registered author (SQL)
    @Query(value = "SELECT b.title AS title, a.name AS name "
            + "FROM book b LEFT JOIN author a ON a.id = b.author_id",
            nativeQuery = true)
    List<AuthorNameBookTitle> findBooksAndAuthorsSqlLeftJoin();

    // Fetch books and authors excluding books that have registered authors (JPQL)
    @Query(value = "SELECT b.title AS title, a.name AS name "
            + "FROM Book b LEFT JOIN b.author a WHERE a.id IS NULL")
    List<AuthorNameBookTitle> findBooksAndAuthorsJpqlLeftJoinExcluding();

    // Fetch books and authors excluding books that have registered authors (SQL)
    @Query(value = "SELECT b.title AS title, a.name AS name "
            + "FROM book b LEFT JOIN author a ON a.id = b.author_id WHERE a.id IS NULL",
            nativeQuery = true)
    List<AuthorNameBookTitle> findBooksAndAuthorsSqlLeftJoinExcluding();
}