package com.quangminh.resulttransformer.dao;

import com.quangminh.resulttransformer.dto.AuthorDtoNoSetters;
import com.quangminh.resulttransformer.dto.AuthorDtoWithSetter;

import java.util.List;

public interface AuthorDao {
    public List<AuthorDtoNoSetters> fetchAuthorsNoSetters();

    public List<AuthorDtoWithSetter> fetchAuthorsWithSetters();
}
