package com.bk.quangminh.onetomanybidirectional.repository;

import com.bk.quangminh.onetomanybidirectional.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author,Long> {

    Optional<Author> findAuthorByName(String name);
}
