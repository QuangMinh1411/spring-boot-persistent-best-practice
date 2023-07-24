package com.example.dtoviaprojectioninterfaceinrepo.repository;

import com.example.dtoviaprojectioninterfaceinrepo.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author,Long> {
    @Transactional(readOnly = true)
    @Query(value = "SELECT a.name AS name,a.age AS age FROM Author a WHERE a.genre=?1")
    List<AuthorNameAge> findFirst2ByGenre(String genre);

    interface AuthorNameAge {
        String getName();
        int getAge();
    }
}
