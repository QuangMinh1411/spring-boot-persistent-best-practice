package com.quangminh.spnativecall.service;

import com.quangminh.spnativecall.dto.AuthorDto;
import com.quangminh.spnativecall.dto.AuthorNicknameAndAge;
import com.quangminh.spnativecall.entity.Author;
import com.quangminh.spnativecall.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookstoreService {

    private final AuthorRepository authorRepository;

    public BookstoreService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }
    public List<Author> fetchAnthologyAuthors(String genre) {
        List<Author> authors = authorRepository.fetchByGenre(genre);
        System.out.println("Result: " + authors);
        return authors;
    }

    public List<AuthorDto> fetchAnthologyAuthorsNameAndAgeDto(String genre) {
        List<Object[]> authorsArray = authorRepository.fetchNicknameAndAgeByGenreDto(genre);
        List<AuthorDto> authors = authorsArray.stream()
                .map(result -> new AuthorDto(
                        (String) result[0],
                        (Integer) result[1]
                )).collect(Collectors.toList());

        System.out.println("Result: " + authors);
        return authors;
    }

    public List<AuthorNicknameAndAge> fetchAnthologyAuthorsNameAndAgeProj(String genre) {
        List<AuthorNicknameAndAge> authorsDto
                = authorRepository.fetchNicknameAndAgeByGenreProj(genre);

        System.out.println("Result: ");
        authorsDto.forEach(a -> System.out.println(a.getNickname() + ", " + a.getAge()));
        return authorsDto;
    }
}
