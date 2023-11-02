package com.quangminh.enumpostgres.service;

import com.quangminh.enumpostgres.entity.Author;
import com.quangminh.enumpostgres.enums.GenreType;
import com.quangminh.enumpostgres.repository.AuthorRepository;
import org.springframework.stereotype.Service;

@Service
public class BookstoreService {

    private final AuthorRepository authorRepository;

    public BookstoreService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }
    public void persistNewAuthor() {
        Author author = new Author();

        author.setName("Maryus Yarn");
        author.setAge(34);
        author.setGenre(GenreType.HORROR);

        authorRepository.save(author);
    }

    public void fetchAuthor() {
        Author author = authorRepository.findById(1L).orElseThrow();
        System.out.println(author);
    }
}
