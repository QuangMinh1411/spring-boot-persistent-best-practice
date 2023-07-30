package com.quangminh.dtoconstructor.service;

import com.quangminh.dtoconstructor.dto.AuthorDto;
import com.quangminh.dtoconstructor.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookstoreService {

    @Autowired
    private AuthorRepository authorRepository;

    public List<AuthorDto> fetchByGenre(String genre) {

        return authorRepository.findByGenre(genre);
    }
}
