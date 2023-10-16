package com.quangminh.databaseview.repository;

import com.quangminh.databaseview.view.GenreAndTitle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GenreAndTitleViewRepository extends JpaRepository<GenreAndTitle, String> {
    List<GenreAndTitle> findByGenre(String genre);
}