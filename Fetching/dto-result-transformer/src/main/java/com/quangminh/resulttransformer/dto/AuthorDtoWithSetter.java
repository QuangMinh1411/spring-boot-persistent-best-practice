package com.quangminh.resulttransformer.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
@Setter
@Getter
public class AuthorDtoWithSetter implements Serializable {
    private static final long serialVersionUID = 1L;

    private  String name;
    private  int age;

}
