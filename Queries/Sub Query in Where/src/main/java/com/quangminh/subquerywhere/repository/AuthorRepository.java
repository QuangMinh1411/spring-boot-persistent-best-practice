package com.quangminh.subquerywhere.repository;

import com.quangminh.subquerywhere.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    @Transactional(readOnly = true)
    @Query("SELECT a FROM Author a WHERE a.id IN "
            + "(SELECT b.authorId FROM Bestseller b)")
    List<Author> fetchTheBest();

    default Map<Long, Author> fetchIdAuthor() {

        return findAll().stream()
                .collect(Collectors.toMap(Author::getId, Function.identity()));
    }

    @Transactional(readOnly = true)
    @Query("SELECT a.genre AS genre, count(a) AS genreCount FROM Author a GROUP BY a.genre")
    List<Object[]> groupByGenreObj();

    default Map<String, Long> groupByGenre() {

        return groupByGenreObj()
                .stream()
                .collect(
                        Collectors.toMap(
                                t -> ((String) t[0]),
                                t -> ((long) t[1])
                        )
                );
    }
}