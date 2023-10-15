package com.quangminh.spnativecall.repository;

import com.quangminh.spnativecall.dto.AuthorNicknameAndAge;
import com.quangminh.spnativecall.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
public interface AuthorRepository extends JpaRepository<Author, Long> {
    @Query(value = "{CALL FETCH_AUTHOR_BY_GENRE (:p_genre)}", nativeQuery = true)
    List<Author> fetchByGenre(@Param("p_genre") String genre);

    @Query(value = "{CALL FETCH_NICKNAME_AND_AGE_BY_GENRE (:p_genre)}", nativeQuery = true)
    List<Object[]> fetchNicknameAndAgeByGenreDto(@Param("p_genre") String genre);

    @Query(value = "{CALL FETCH_NICKNAME_AND_AGE_BY_GENRE (:p_genre)}", nativeQuery = true)
    List<AuthorNicknameAndAge> fetchNicknameAndAgeByGenreProj(@Param("p_genre") String genre);
}