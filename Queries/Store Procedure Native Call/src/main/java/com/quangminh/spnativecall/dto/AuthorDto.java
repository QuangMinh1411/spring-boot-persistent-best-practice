package com.quangminh.spnativecall.dto;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.quangminh.spnativecall.entity.Author}
 */
@Value
public class AuthorDto implements Serializable {

    String nickname;
    int age;
}