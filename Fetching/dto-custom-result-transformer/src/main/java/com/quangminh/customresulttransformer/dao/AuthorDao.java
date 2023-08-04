package com.quangminh.customresulttransformer.dao;

import com.quangminh.customresulttransformer.dto.AuthorDto;

import java.util.List;

public interface AuthorDao {
    List<AuthorDto> fetchAuthorWithBook();
}
