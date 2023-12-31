package com.quangminh.autogenerate.service;

import com.quangminh.autogenerate.entity.AuthorBad;
import com.quangminh.autogenerate.entity.AuthorGood;
import com.quangminh.autogenerate.repository.AuthorBadRepository;
import com.quangminh.autogenerate.repository.AuthorGoodRepository;
import org.springframework.stereotype.Service;

@Service
public class BookstoreService {

    private final AuthorGoodRepository authorGoodRepository;
    private final AuthorBadRepository authorBadRepository;

    public BookstoreService(AuthorGoodRepository authorGoodRepository, AuthorBadRepository authorBadRepository) {
        this.authorGoodRepository = authorGoodRepository;
        this.authorBadRepository = authorBadRepository;
    }

    public void persistGoodAuthor() {

        AuthorGood good = new AuthorGood();
        good.setName("Joana Nimar");
        good.setAge(34);
        good.setGenre("History");

        authorGoodRepository.save(good);
    }

    public void persistBadAuthor() {

        AuthorBad bad = new AuthorBad();
        bad.setName("Alicia Tom");
        bad.setAge(38);
        bad.setGenre("Anthology");

        authorBadRepository.save(bad);
    }

}
