package com.quangminh.sequentialnumber.service;

import com.quangminh.sequentialnumber.dto.AuthorDto;
import com.quangminh.sequentialnumber.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookstoreService {

    private final AuthorRepository authorRepository;

    public BookstoreService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }
    public List<AuthorDto> fetchAuthorsWithSeqNumber1() {
        List<AuthorDto> authors = authorRepository.fetchWithSeqNumber1();

        authors.forEach(a -> System.out.println(a.getRowNum()
                + ", " + a.getName() + ", " + a.getAge()));
        return authors;
    }

    public List<AuthorDto> fetchAuthorsWithSeqNumber2() {
        List<AuthorDto> authors = authorRepository.fetchWithSeqNumber2();

        authors.forEach(a -> System.out.println(a.getRowNum()
                + ", " + a.getName() + ", " + a.getAge()));
        return authors;
    }

    public List<AuthorDto> fetchAuthorsWithSeqNumber3() {
        List<AuthorDto> authors = authorRepository.fetchWithSeqNumber3();

        authors.forEach(a -> System.out.println(a.getRowNum()
                + ", " + a.getName() + ", " + a.getAge()));
        return authors;
    }

    public List<AuthorDto> fetchAuthorsWithSeqNumber4() {
        List<AuthorDto> authors = authorRepository.fetchWithSeqNumber4();

        authors.forEach(a -> System.out.println(a.getRowNum()
                + ", " + a.getName() + ", " + a.getAge()));
        return authors;
    }

}
