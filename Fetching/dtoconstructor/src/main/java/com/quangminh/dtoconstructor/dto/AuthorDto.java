package com.quangminh.dtoconstructor.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.quangminh.dtoconstructor.entity.Author}
 */

@Data
public class AuthorDto implements Serializable {
    private static final long serialVersionUID = 1L;
    private final String name;
    private final int age;

    public AuthorDto(Integer age, String name) {
        this.age = age;
        this.name = name;
    }
}