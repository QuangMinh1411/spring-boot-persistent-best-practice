package com.quangminh.queryplancache.service;

import com.quangminh.queryplancache.entity.Author;
import com.quangminh.queryplancache.repository.AuthorRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

import java.util.List;

@Service
public class BookstoreService {

    private final AuthorRepository authorRepository;

    public BookstoreService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }
    public void fetAuthorsbyGenre(String genre,int age){
        StopWatch sw = new StopWatch();
        sw.start();
        for(int i=1;i<=5000;i++){
            List<Author> authorsByGenre = authorRepository.fetchByGenre(genre);
            List<Author> authorsByAge = authorRepository.fetchByAge(age);
        }
        sw.stop();
        System.out.println("Elapsed time: " + sw.getTotalTimeMillis() + " ms");
    }
}
