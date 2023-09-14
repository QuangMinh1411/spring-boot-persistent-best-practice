package com.quangminh.timestampgenerator.service;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Random;

@Service
public class UserService {
    public String getCurrentUserName() {
        // use Spring Security to retrive the currently logged-in user(s)
        return Arrays.asList("mark1990", "adrianm", "dan555")
                .get(new Random().nextInt(3));
    }
}
