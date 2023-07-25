package com.quangminh.dtoentityviaprojection.service;

import com.quangminh.dtoentityviaprojection.dto.BookstoreDto;
import com.quangminh.dtoentityviaprojection.entity.Author;
import com.quangminh.dtoentityviaprojection.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookstoreService {

    @Autowired
    private AuthorRepository authorRepository;

    @Transactional
    public List<BookstoreDto> fetchAuthorsPaging(int page,int size){
        List<BookstoreDto> dtos = authorRepository.fetchAllPaging(PageRequest.of(page,size));
        return dtos;
    }

    @Transactional
    public List<BookstoreDto> fetchAuthors(int index,Author author){
        List<BookstoreDto> dtos = authorRepository.fetchAll();
        Author authorold = dtos.get(index).getAuthor();
        authorold.setAge(author.getAge());
        authorold.setName(author.getName());
        authorold.setGenre(author.getGenre());
        return dtos;
    }


}
