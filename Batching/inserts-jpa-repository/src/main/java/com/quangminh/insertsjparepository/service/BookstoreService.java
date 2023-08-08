package com.quangminh.insertsjparepository.service;

import com.quangminh.insertsjparepository.entity.Author;
import com.quangminh.insertsjparepository.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookstoreService {
    private final AuthorRepository authorRepository;
    @Value("${spring.jpa.properties.hibernate.jdbc.batch_size}")
    private int batchSize;


    public BookstoreService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public void batchAuthors(){
        List<Author> authors = new ArrayList<>();

        for (int i = 0; i < 1000; i++) {
            Author author = new Author();
            author.setId((long) i + 1);
            author.setName("Name_" + i);
            author.setGenre("Genre_" + i);
            author.setAge(18 + i);

            authors.add(author);

            if (i % batchSize == 0 && i > 0) {
                authorRepository.saveAll(authors);
                authors.clear();
            }
        }

        if (authors.size() > 0) {
            authorRepository.saveAll(authors);
            authors.clear();
        }
    }

    public List<Author> fetchAll(){
        return authorRepository.findAll();
    }
}
