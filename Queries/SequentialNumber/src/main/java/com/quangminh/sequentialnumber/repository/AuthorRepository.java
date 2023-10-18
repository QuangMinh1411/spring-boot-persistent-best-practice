package com.quangminh.sequentialnumber.repository;

import com.quangminh.sequentialnumber.AuthorDtoRank;
import com.quangminh.sequentialnumber.dto.AuthorDto;
import com.quangminh.sequentialnumber.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
public interface AuthorRepository extends JpaRepository<Author, Long> {
    @Query(value = "SELECT ROW_NUMBER() OVER(ORDER BY age) "
            + "rowNum, name, age FROM author",
            nativeQuery = true)
    List<AuthorDto> fetchWithSeqNumber1();

    @Query(value = "SELECT ROW_NUMBER() OVER() "
            + "rowNum, name, age FROM author ORDER BY age",
            nativeQuery = true)
    List<AuthorDto> fetchWithSeqNumber2();

    @Query(value = "SELECT ROW_NUMBER() OVER(ORDER BY age) "
            + "rowNum, name, age FROM author ORDER BY name",
            nativeQuery = true)
    List<AuthorDto> fetchWithSeqNumber3();

    @Query(value = "SELECT ROW_NUMBER() OVER(ORDER BY age, name DESC) "
            + "rowNum, name, age FROM author",
            nativeQuery = true)
    List<AuthorDto> fetchWithSeqNumber4();

    //Rank
    @Query(value = "SELECT RANK() OVER(PARTITION BY genre ORDER BY name DESC) "
            + "rankNum, name, genre FROM author",
            nativeQuery = true)
    List<AuthorDtoRank> fetchWithRank1();

    @Query(value = "SELECT RANK() OVER(ORDER BY genre) "
            + "rankNum, name, genre FROM author ORDER BY name",
            nativeQuery = true)
    List<AuthorDtoRank> fetchWithRank2();
}