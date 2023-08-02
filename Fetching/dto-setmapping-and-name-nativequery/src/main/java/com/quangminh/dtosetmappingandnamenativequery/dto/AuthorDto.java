package com.quangminh.dtosetmappingandnamenativequery.dto;

import lombok.Data;

import java.io.Serializable;
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
