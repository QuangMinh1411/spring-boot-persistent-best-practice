package com.quangminh.projectionandcollections.dto;

import java.util.List;

/**
 * Projection for {@link com.quangminh.projectionandcollections.entity.Author}
 */
public interface AuthorDto {
    String getName();

    String getGenre();

    List<BookDto> getBooks();

    /**
     * Projection for {@link com.quangminh.projectionandcollections.entity.Book}
     */
    interface BookDto {
        String getTitle();
    }
}