package com.quangminh.sequentialnumber.dto;

/**
 * Projection for {@link com.quangminh.sequentialnumber.entity.Author}
 */
public interface AuthorDto {
    int getAge();

    String getName();
    int getRowNum();
}