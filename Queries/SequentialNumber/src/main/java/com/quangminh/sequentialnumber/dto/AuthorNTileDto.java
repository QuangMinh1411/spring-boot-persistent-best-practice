package com.quangminh.sequentialnumber.dto;

/**
 * Projection for {@link com.quangminh.sequentialnumber.entity.Author}
 */
public interface AuthorNTileDto {
    int getAge();

    String getName();

    String getGenre();
    int getTile();
}