package com.quangminh.resultsetmappingnamednavtivequery.dto;

import lombok.Data;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.quangminh.resultsetmappingnamednavtivequery.entity.Author}
 */
@Data
public class AuthorDto implements Serializable {
    private static final long serialVersionUID = 1L;
    private final String name;
    private final int age;

    public AuthorDto(String name, int age) {
        this.name = name;
        this.age = age;
    }
}