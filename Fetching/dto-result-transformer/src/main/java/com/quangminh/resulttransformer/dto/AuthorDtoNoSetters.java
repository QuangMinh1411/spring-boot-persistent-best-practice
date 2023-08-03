package com.quangminh.resulttransformer.dto;

import lombok.Getter;

import java.io.Serializable;
@Getter
public class AuthorDtoNoSetters implements Serializable {
    private static final long serialVersionUID = 1L;

    private final String name;
    private final int age;

    public AuthorDtoNoSetters(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
