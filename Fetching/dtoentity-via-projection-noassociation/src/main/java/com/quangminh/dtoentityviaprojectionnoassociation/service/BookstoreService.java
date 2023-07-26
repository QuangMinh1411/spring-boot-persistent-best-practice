package com.quangminh.dtoentityviaprojectionnoassociation.service;

import com.quangminh.dtoentityviaprojectionnoassociation.dto.BookstoreDto;
import com.quangminh.dtoentityviaprojectionnoassociation.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookstoreService {

    @Autowired
    private AuthorRepository authorRepository;

    public List<BookstoreDto> fetchAuthors(){
        List<BookstoreDto> dtos = authorRepository.fetchAll();
//        dtos.get(index).getAuthor().setAge(age);
        return dtos;
    }
}
