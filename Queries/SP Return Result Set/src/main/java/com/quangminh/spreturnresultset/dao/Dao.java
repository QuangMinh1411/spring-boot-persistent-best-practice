package com.quangminh.spreturnresultset.dao;

import com.quangminh.spreturnresultset.dto.AuthorDto;
import com.quangminh.spreturnresultset.entity.Author;

import java.util.List;

public interface Dao {
    public List<Author> fetchByGenre1(String genre);
    public List<Author> fetchByGenre2(String genre);
    public List<AuthorDto> fetchByGenre3(String genre);
    public List<AuthorDto> fetchByGenre4(String genre);
}
