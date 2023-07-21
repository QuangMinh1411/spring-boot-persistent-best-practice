package com.quangminh.attributelazyloadingbasic.service;

import com.quangminh.attributelazyloadingbasic.dto.AuthorDto;
import com.quangminh.attributelazyloadingbasic.entity.Author;
import com.quangminh.attributelazyloadingbasic.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookstoreService {
    private final AuthorRepository authorRepository;

    @Transactional
    public Author createAuthor(Author author) {
        return authorRepository.save(author);
    }

    public List<Author> fetchAuthorsByAgeGreaterThanEqual(int age){
        return authorRepository.findByAgeGreaterThanEqual(age);
    }

    @Transactional(readOnly = true)
    public Author fetchAuthorAvatarviaId(Long id){
        return authorRepository.findById(id).orElseThrow();

    }

    @Transactional(readOnly = true)
    public List<AuthorDto> fetchAuthorsDetail(int age){
        return authorRepository.findDtoByAgeGreaterThanEqual(age);
    }
}
