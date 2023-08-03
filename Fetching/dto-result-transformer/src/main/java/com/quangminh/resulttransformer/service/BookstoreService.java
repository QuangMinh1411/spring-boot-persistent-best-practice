package com.quangminh.resulttransformer.service;

import com.quangminh.resulttransformer.dao.Dao;
import com.quangminh.resulttransformer.dto.AuthorDtoNoSetters;
import com.quangminh.resulttransformer.dto.AuthorDtoWithSetter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookstoreService {
    private final Dao dao;

    public BookstoreService(Dao dao) {
        this.dao = dao;
    }

    public List<AuthorDtoNoSetters> fetchAuthorsNoSetters() {

        return dao.fetchAuthorsNoSetters();
    }

    public List<AuthorDtoWithSetter> fetchAuthorsWithSetters() {

        return dao.fetchAuthorsWithSetters();
    }
}
