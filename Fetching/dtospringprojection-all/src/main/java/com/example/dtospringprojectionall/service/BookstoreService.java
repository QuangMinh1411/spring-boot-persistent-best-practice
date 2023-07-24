package com.example.dtospringprojectionall.service;

import com.example.dtospringprojectionall.dto.AuthorNamedNativeQueryNameAge;
import com.example.dtospringprojectionall.dto.AuthorNamedQueryNameAge;
import com.example.dtospringprojectionall.entity.AuthorNamedQuery;
import com.example.dtospringprojectionall.projection.AuthorNameAge;
import com.example.dtospringprojectionall.repository.AuthorNamedNativeQueryRepository;
import com.example.dtospringprojectionall.repository.AuthorNamedQueryRepository;
import com.example.dtospringprojectionall.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookstoreService {
    private final AuthorNamedQueryRepository authorNamedQueryRepository;
    private final AuthorNamedNativeQueryRepository authorNamedNativeQueryRepository;
    private final AuthorRepository authorRepository;
    //AuthorNamedQuery
    public List<AuthorNamedQueryNameAge> fetchAuthorNamesAndAge(){
        return authorNamedQueryRepository.fetchNameAndAge();
    }

    public List<String> fetchAuthorsName(){
        return authorNamedQueryRepository.fetchName();
    }

    public List<AuthorNamedNativeQueryNameAge> fetchAuthorNamesAndAgeNative(){
        return authorNamedNativeQueryRepository.fetchNameAndAge();
    }

    public List<String> fetchAuthorsNameNative(){
        return authorNamedNativeQueryRepository.fetchName();
    }


    public List<AuthorNameAge> fetchFirst2ByGenre(String genre){
        return authorRepository.findFirst2ByGenre(genre);
    }
}
