package com.quangminh.projectionandcollections.dto;

import com.quangminh.projectionandcollections.entity.Book;

import java.util.List;

/**
 * Projection for {@link com.quangminh.projectionandcollections.entity.Author}
 */
public interface SimpleAuthorDto {
    String getName();

    String getGenre();

    String getTitle();
}