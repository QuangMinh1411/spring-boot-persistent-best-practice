package com.quangminh.dtooffsetpagination.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Projection for {@link com.quangminh.dtooffsetpagination.entity.Author}
 */
public interface AuthorDto {
    int getAge();

    String getName();

//    @JsonIgnore
    public long getTotal();
}