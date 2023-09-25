package com.quangminh.keysetnextpage.service;

import com.quangminh.keysetnextpage.dto.AuthorDto;
import com.quangminh.keysetnextpage.entity.Author;
import com.quangminh.keysetnextpage.repository.AuthorRepository;
import com.quangminh.keysetnextpage.view.AuthorView;
import com.quangminh.keysetnextpage.view.AuthorViewDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookstoreService {

    private final AuthorRepository authorRepository;

    public BookstoreService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }
    public AuthorView fetchNextPage(long id, int limit) {
        List<Author> authors = authorRepository.fetchAll(id, limit + 1);

        if (authors.size() == (limit + 1)) {
            authors.remove(authors.size() - 1);
            return new AuthorView(authors, false);
        }

        return new AuthorView(authors, true);
    }

    public AuthorViewDto fetchNextPageDto(long id, int limit) {
        List<AuthorDto> authors = authorRepository.fetchAllDto(id, limit + 1);

        if (authors.size() == (limit + 1)) {
            authors.remove(authors.size() - 1);
            return new AuthorViewDto(authors, false);
        }

        return new AuthorViewDto(authors, true);
    }
}
