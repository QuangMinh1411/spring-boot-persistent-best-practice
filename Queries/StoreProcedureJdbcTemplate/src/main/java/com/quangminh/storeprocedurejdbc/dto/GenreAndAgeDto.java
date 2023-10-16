package com.quangminh.storeprocedurejdbc.dto;

import lombok.Data;

import java.io.Serializable;
@Data
public class GenreAndAgeDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private String genre;
    private int age;
}
