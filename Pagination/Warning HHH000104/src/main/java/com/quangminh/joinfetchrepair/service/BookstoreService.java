package com.quangminh.joinfetchrepair.service;

import com.quangminh.joinfetchrepair.entity.Author;
import com.quangminh.joinfetchrepair.repository.AuthorRepository;
import jakarta.persistence.Tuple;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookstoreService {

    private final AuthorRepository authorRepository;

    public BookstoreService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }
    @Transactional
    public Page<Author> fetchPageOfAuthorsWithBooksByGenre(String genre,int page, int size) {

        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.ASC, "name"));

        Page<Long> pageOfIds = authorRepository.fetchPageOfIdsByGenre(genre, pageable);
        List<Author> listOfAuthors = authorRepository.fetchWithBooksJoinFetch(pageOfIds.getContent());
        Page<Author> pageOfAuthors = new PageImpl(listOfAuthors, pageable, pageOfIds.getTotalElements());

        return pageOfAuthors;
    }

    @Transactional
    public Slice<Author> fetchSliceOfAuthorsWithBooksByGenre(String genre,int page, int size) {

        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.ASC, "name"));

        Slice<Long> pageOfIds = authorRepository.fetchSliceOfIdsByGenre(genre, pageable);
        List<Author> listOfAuthors = authorRepository.fetchWithBooksJoinFetch(pageOfIds.getContent());
        Slice<Author> sliceOfAuthors = new SliceImpl(listOfAuthors, pageable, pageOfIds.hasNext());

        return sliceOfAuthors;
    }

    @Transactional
    public List<Author> fetchListOfAuthorsWithBooksByGenre(String genre,int page, int size) {

        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.ASC, "name"));

        List<Long> listOfIds = authorRepository.fetchListOfIdsByGenre(genre, pageable);
        List<Author> listOfAuthors = authorRepository.fetchWithBooksJoinFetch(listOfIds);

        return listOfAuthors;
    }

    @Transactional
    public Page<Author> fetchPageOfAuthorsWithBooksByGenreEntityGraph(String genre,int page, int size) {

        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.ASC, "name"));

        Page<Long> pageOfIds = authorRepository.fetchPageOfIdsByGenre(genre, pageable);
        List<Author> listOfAuthors = authorRepository.fetchWithBooksEntityGraph(pageOfIds.getContent());
        Page<Author> pageOfAuthors = new PageImpl(listOfAuthors, pageable, pageOfIds.getTotalElements());

        return pageOfAuthors;
    }

    @Transactional
    public Page<Author> fetchPageOfAuthorsWithBooksByGenreTuple(String genre,int page, int size) {

        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.ASC, "name"));

        List<Tuple> tuples = authorRepository.fetchTupleOfIdsByGenre(genre, pageable);

        List<Long> listOfIds = new ArrayList<>(tuples.size());
        for(Tuple tuple: tuples) {
            System.out.println(tuple);
           var id = (BigInteger)tuple.get("id");
            listOfIds.add((Long) id.longValue());
        }

        List<Author> listOfAuthors = authorRepository.fetchWithBooksJoinFetch(listOfIds);
        Page<Author> pageOfAuthors = new PageImpl(listOfAuthors, pageable, ((BigInteger) tuples.get(0).get("total")).longValue());

        return pageOfAuthors;
    }
}
