package com.quangminh.customresulttransformer.transformer;

import com.quangminh.customresulttransformer.BookDto;
import com.quangminh.customresulttransformer.dto.AuthorDto;
import org.hibernate.transform.ResultTransformer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AuthorBookTransformer implements ResultTransformer {
    private Map<Long, AuthorDto> authorDtoMap = new HashMap<>();
    @Override
    public Object transformTuple(Object[] objects, String[] strings) {
        Long authorId = ((Number) objects[0]).longValue();
        AuthorDto authorDto = authorDtoMap.get(authorId);
        if(authorDto==null){
            authorDto = new AuthorDto();
            authorDto.setId(authorId);
            authorDto.setName((String) objects[1]);
            authorDto.setAge((int) objects[2]);
        }
        BookDto bookDto = new BookDto();
        bookDto.setId(((Number) objects[3]).longValue());
        bookDto.setTitle((String) objects[4]);
        authorDto.addBook(bookDto);
        authorDtoMap.putIfAbsent(authorDto.getId(),authorDto);
        return authorDto;
    }

    @Override
    public List<AuthorDto> transformList(List resultList) {
        return new ArrayList<>(authorDtoMap.values());
    }
}
