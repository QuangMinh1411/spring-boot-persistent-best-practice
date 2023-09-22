package com.quangminh.dtooffsetpagination.repository;

import com.quangminh.dtooffsetpagination.dto.AuthorDto;
import com.quangminh.dtooffsetpagination.entity.Author;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    @Query(value = "SELECT t.total, name, age FROM author, "
            + "(SELECT count(*) as total FROM author) AS t",
            nativeQuery = true)
    List<AuthorDto> fetchAllNative(Pageable pageable);

    @Query(value = "SELECT a.name as name, a.age as age, "
            + "(SELECT count(a) FROM Author a) AS total FROM Author a")
    List<AuthorDto> fetchAllJpql(Pageable pageable);

    @Query(value = "SELECT t.total, name, age FROM author, "
            + "(SELECT count(*) AS total FROM author) AS t "
            + "ORDER BY age LIMIT ?1, ?2",
          nativeQuery = true)
    List<AuthorDto> fetchAllNativeList(int page, int size);

    @Query(value = "SELECT a.name as name, a.age as age, "
            + "(SELECT count(a) FROM Author a) AS total FROM Author a")
    List<AuthorDto> fetchAllJpqlList(Pageable pageable);
}