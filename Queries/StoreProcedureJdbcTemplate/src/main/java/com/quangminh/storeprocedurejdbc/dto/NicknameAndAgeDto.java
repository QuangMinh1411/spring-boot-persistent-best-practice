package com.quangminh.storeprocedurejdbc.dto;

import lombok.Data;

import java.io.Serializable;
@Data
public class NicknameAndAgeDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private String nickname;
    private int age;
}
