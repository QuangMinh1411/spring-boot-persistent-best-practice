package com.quangminh.storeprocedurejdbc.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
@Getter
@Setter
public class AuthorDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private String nickname;
    private int age;
}
