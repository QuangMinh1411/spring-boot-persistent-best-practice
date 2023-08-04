package com.quangminh.customresulttransformer.service;

import com.quangminh.customresulttransformer.dao.AuthorDao;
import com.quangminh.customresulttransformer.dao.Dao;
import com.quangminh.customresulttransformer.dto.AuthorDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookstoreService {

    private final Dao dao;

    public BookstoreService(Dao dao) {
        this.dao = dao;
    }
    public List<AuthorDto> fetchAuthorsWithBooks(){
        return dao.fetchAuthorWithBook();
    }
}
