package com.quangminh.dtoentityviaprojectionnoassociation.repository;

import com.quangminh.dtoentityviaprojectionnoassociation.dto.BookstoreDto;
import com.quangminh.dtoentityviaprojectionnoassociation.entity.Author;
import com.quangminh.dtoentityviaprojectionnoassociation.projection.AuthorNameAge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    @Transactional(readOnly = true)
    @Query("select a as author,b.title as title from Author a join Book b ON a.genre=b.genre order by a.id")
    List<BookstoreDto> fetchAll();

    @Transactional(readOnly = true)
    @Query("select a.name as name,a.age as age from Author a where a.age>?1")
    List<AuthorNameAge> fetchByAge(int age);
}