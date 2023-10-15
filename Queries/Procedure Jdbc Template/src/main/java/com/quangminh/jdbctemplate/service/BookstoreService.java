package com.quangminh.jdbctemplate.service;

import com.quangminh.jdbctemplate.entity.Author;
import jakarta.annotation.PostConstruct;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;

@Service
public class BookstoreService {
    private final JdbcTemplate jdbcTemplate;

    public BookstoreService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @PostConstruct
    void init() {
        jdbcTemplate.setResultsMapCaseInsensitive(true);
    }

    public List<Author> fetchAnthologyAuthors(String genre) {
        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName("FETCH_AUTHOR_BY_GENRE");

        List<Author> authors = simpleJdbcCall.execute(Map.of("p_genre", genre)).entrySet()
                .stream()
                .filter(m -> "#result-set-1".equals(m.getKey()))
                .map(m -> (List<Map<String, Object>>) m.getValue())
                .flatMap(List::stream)
                .map(BookstoreService::fetchAuthor)
                .collect(toList());

        System.out.println("Result: " + authors);
        return authors;
    }

    public static Author fetchAuthor(Map<String, Object> data) {

        Author author = new Author();

        author.setId((Long) data.get("id"));
        author.setName((String) data.get("name"));
        author.setGenre((String) data.get("genre"));
        author.setAge((int) data.get("age"));

        return author;
    }
}
