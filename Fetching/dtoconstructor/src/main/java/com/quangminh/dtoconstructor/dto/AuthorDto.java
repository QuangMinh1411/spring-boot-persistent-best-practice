package com.quangminh.dtoconstructor.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.quangminh.dtoconstructor.entity.Author}
 */
@AllArgsConstructor
@Data
public class AuthorDto implements Serializable {
    private static final long serialVersionUID = 1L;
    Integer age;
    String name;
}