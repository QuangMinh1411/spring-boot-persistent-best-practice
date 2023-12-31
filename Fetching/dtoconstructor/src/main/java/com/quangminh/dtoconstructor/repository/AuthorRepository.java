package com.quangminh.dtoconstructor.repository;

import com.quangminh.dtoconstructor.dto.AuthorDto;
import com.quangminh.dtoconstructor.entity.Author;
import jakarta.persistence.Tuple;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    @Transactional(readOnly = true)
    List<AuthorDto> findByGenre(String genre);

    @Transactional(readOnly = true)
    @Query(value = "select new com.quangminh.dtoconstructor.dto.AuthorDto(a.age,a.name) from Author a")
    List<AuthorDto> fetchAuthors();

    @Transactional(readOnly = true)
    @Query("select a.id as id,a.name as name,a.age as age from Author a")
    List<Tuple> fetchAuthorsByTuple();
}