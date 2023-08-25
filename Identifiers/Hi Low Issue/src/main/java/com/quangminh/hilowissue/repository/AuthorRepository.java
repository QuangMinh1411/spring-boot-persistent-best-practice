package com.quangminh.hilowissue.repository;

import com.quangminh.hilowissue.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    @Modifying
    @Query(value = "INSERT INTO author (id, name) VALUES (NEXTVAL('hilo_sequence'), ?1)",
            nativeQuery = true)
    public void saveNative(String name);
}