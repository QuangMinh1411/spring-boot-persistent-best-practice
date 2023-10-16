package com.quangminh.databaseview.service;

import com.quangminh.databaseview.repository.GenreAndTitleViewRepository;
import com.quangminh.databaseview.view.GenreAndTitle;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookstoreService {

    private final GenreAndTitleViewRepository genreAndTitleViewRepository;

    public BookstoreService(GenreAndTitleViewRepository genreAndTitleViewRepository) {
        this.genreAndTitleViewRepository = genreAndTitleViewRepository;
    }
    public List<GenreAndTitle> displayView(){
        return genreAndTitleViewRepository.findAll();
    }
    public List<GenreAndTitle> displayViewByGenre(String genre){
        return genreAndTitleViewRepository.findByGenre(genre);
    }
}
