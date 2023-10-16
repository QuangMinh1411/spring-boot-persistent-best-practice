package com.quangminh.spreturnresultset.dto;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.quangminh.spreturnresultset.entity.Author}
 */
@Value
public class AuthorDto implements Serializable {
    String nickname;
    int age;

}