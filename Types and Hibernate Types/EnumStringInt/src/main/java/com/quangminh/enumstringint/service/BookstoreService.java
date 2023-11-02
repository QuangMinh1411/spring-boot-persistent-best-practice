package com.quangminh.enumstringint.service;

import com.quangminh.enumstringint.entity.Author;
import com.quangminh.enumstringint.enums.GenreType;
import com.quangminh.enumstringint.repository.AuthorRepository;
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
        author.setGenre(GenreType.HISTORY);

        authorRepository.save(author);
    }

    public Author fetchAuthor(long authorId) {
        Author author = authorRepository.findById(authorId).orElseThrow();
        System.out.println(author);
        return author;
    }
}
