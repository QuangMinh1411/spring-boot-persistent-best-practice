package com.quangminh.reuseprojection.repository;

import com.quangminh.reuseprojection.dto.AuthorDto;
import com.quangminh.reuseprojection.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    @Query("select a.age as age,a.name as name,a.genre as genre,a.email as email,a.address as address from Author a")
    List<AuthorDto> fetchAll();

    @Query("select a.age as age,a.name as name,a.genre as genre from Author a")
    List<AuthorDto> fetchAgeNameGenre();

    @Query("select a.name as name,a.email as email from Author a")
    List<AuthorDto> fetchNameEmail();


    <T> List<T> findByGenre(String genre,Class<T> type);
    <T> T findByName(String name,Class<T> type);
    @Query("select a from Author a where a.name=?1 and a.age=?2")
    <T> T findByNameAndAge(String name,int age, Class<T> type);

}