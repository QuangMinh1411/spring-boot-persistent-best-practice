package com.quangminh.lobtostring.service;

import com.quangminh.lobtostring.entity.Author;
import com.quangminh.lobtostring.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;

@Service
public class BookstoreService {

    private final AuthorRepository authorRepository;

    public BookstoreService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }
    public void newAuthor() throws IOException {

        Author mt = new Author();
        mt.setName("Martin Ticher");
        mt.setAge(43);
        mt.setGenre("Horror");

        mt.setAvatar(Files.readAllBytes(new File("avatars/mt_avatar.png").toPath()));
        mt.setBiography(Files.readString(new File("biography/mt_bio.txt").toPath()));

        authorRepository.save(mt);
    }

    public void fetchAuthor() {

        Author author = authorRepository.findByName("Martin Ticher");
        System.out.println("Author bio: " + author.getBiography());
        System.out.println("Author avatar: " + Arrays.toString(author.getAvatar()));
    }
    public byte[] displayAuthorImg(String name){
        Author author = authorRepository.findByName(name);
        return author.getAvatar();
    }
}
