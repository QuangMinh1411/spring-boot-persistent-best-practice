package com.quangminh.pagedto.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Projection for {@link com.quangminh.pagedto.entity.Author}
 */
public interface AuthorDto {
    int getAge();

    String getName();
    @JsonIgnore
    long getTotal();
}