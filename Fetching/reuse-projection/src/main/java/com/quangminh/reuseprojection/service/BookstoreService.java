package com.quangminh.reuseprojection.service;

import com.quangminh.reuseprojection.dto.AuthorDto;
import com.quangminh.reuseprojection.dto.AuthorGenreDTO;
import com.quangminh.reuseprojection.dto.AuthorNameEmailDto;
import com.quangminh.reuseprojection.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookstoreService {

    @Autowired
    private AuthorRepository authorRepository;

    @Transactional(readOnly = true)
    public List<AuthorDto> fetchAll(){
        return authorRepository.fetchAll();
    }

    @Transactional(readOnly = true)
    public List<AuthorDto> fetchAgeNameGenre(){
        return authorRepository.fetchAgeNameGenre();
    }

    @Transactional(readOnly = true)
    public List<AuthorDto> fetchNameEmail(){
        return authorRepository.fetchNameEmail();
    }

    @Transactional(readOnly = true)
    public AuthorNameEmailDto fetchAuthorByNameAsDtoNameEmailJpql(String name){
        return authorRepository.findByName(name,AuthorNameEmailDto.class);
    }

    @Transactional(readOnly = true)
    public AuthorNameEmailDto fetchAuthorNameEmailDtoJpql(String name,int age){
        return authorRepository.findByNameAndAge(name,age,AuthorNameEmailDto.class);
    }

    @Transactional(readOnly = true)
    public List<AuthorGenreDTO> fetchAuthorGenreDtoJpa(String genre){
        return authorRepository.findByGenre(genre, AuthorGenreDTO.class);
    }



}
