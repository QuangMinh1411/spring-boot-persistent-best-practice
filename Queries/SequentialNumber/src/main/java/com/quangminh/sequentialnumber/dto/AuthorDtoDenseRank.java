package com.quangminh.sequentialnumber.dto;

/**
 * Projection for {@link com.quangminh.sequentialnumber.entity.Author}
 */
public interface AuthorDtoDenseRank {
    int getAge();

    String getName();

    String getGenre();

    int getRankNum();
}