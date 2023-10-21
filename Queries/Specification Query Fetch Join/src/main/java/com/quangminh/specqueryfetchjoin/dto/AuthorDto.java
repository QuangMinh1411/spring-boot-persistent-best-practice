package com.quangminh.specqueryfetchjoin.dto;

import java.util.List;

/**
 * Projection for {@link com.quangminh.specqueryfetchjoin.entity.Author}
 */
public interface AuthorDto {
    Long getId();

    String getName();

    String getGenre();

    int getAge();

    List<BookDto> getBooks();
}