package com.quangminh.dtosetmappingandnamenativequery.dao;

import com.quangminh.dtosetmappingandnamenativequery.dto.AuthorDto;

import java.util.List;

public interface AuthorDao {
    List<AuthorDto> fetchNameAndAge();
}
