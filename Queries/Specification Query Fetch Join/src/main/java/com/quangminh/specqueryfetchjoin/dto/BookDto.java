package com.quangminh.specqueryfetchjoin.dto;

/**
 * Projection for {@link com.quangminh.specqueryfetchjoin.entity.Book}
 */
public interface BookDto {
    Long getId();

    String getTitle();

    String getIsbn();
}