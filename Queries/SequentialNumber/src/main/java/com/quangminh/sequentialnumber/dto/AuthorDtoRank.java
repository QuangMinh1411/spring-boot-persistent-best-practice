package com.quangminh.sequentialnumber.dto;

/**
 * Projection for {@link com.quangminh.sequentialnumber.entity.Author}
 */
public interface AuthorDtoRank {
    String getGenre();

    String getName();

    int getRankNum();
}