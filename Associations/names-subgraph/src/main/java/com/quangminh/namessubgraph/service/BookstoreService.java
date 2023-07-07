package com.quangminh.namessubgraph.service;

import com.quangminh.namessubgraph.entity.Author;
import com.quangminh.namessubgraph.entity.Publisher;
import com.quangminh.namessubgraph.repository.AuthorRepository;
import com.quangminh.namessubgraph.repository.PublisherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.quangminh.namessubgraph.specs.AuthorSpecs.isAgeGt35;
import static com.quangminh.namessubgraph.specs.PublisherSpecs.isIdGt2;

@Service
@RequiredArgsConstructor
public class BookstoreService {
    private final AuthorRepository authorRepository;
    private final PublisherRepository publisherRepository;

    public List<Author> displayAuthorsWithBooksAndPublishers() {

        return authorRepository.findAll();

    }

    public List<Author> displayAuthorsByAgeWithBooksAndPublishers(int age) {

        return authorRepository.findByAgeLessThanOrderByNameDesc(age);


    }

    public List<Author> displayAuthorsByAgeWithBooksAndPublishers(int low,int high) {

        return authorRepository.fetchAllAgeBetween(low,high);


    }

    public List<Author> displayAuthorsWithBooksAndPublishersWithSpec() {

        return authorRepository.findAll(isAgeGt35());


    }

    public List<Publisher> displayPublishersWithBooksAndAuthors() {

        return publisherRepository.findAll();


    }

    public List<Publisher> displayPublishersByIdWithBooksAndAuthors(Long id) {

        return publisherRepository.findByIdLessThanOrderByCompanyDesc(id);


    }

    public List<Publisher> displayPublishersWithBooksAndAuthorsWithSpec() {

        return publisherRepository.findAll(isIdGt2());


    }

    public List<Publisher> displayPublishersByIdBetween1And3WithBooksAndAuthors(int low,int high) {

        return publisherRepository.fetchAllIdBetween(low,high);


    }
}
