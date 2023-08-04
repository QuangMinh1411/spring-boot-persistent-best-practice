package com.quangminh.customresulttransformer.dto;

import com.quangminh.customresulttransformer.BookDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * DTO for {@link com.quangminh.customresulttransformer.entity.Author}
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthorDto implements Serializable {
    private Long id;
    private String name;
    private int age;

    private List<BookDto> books = new ArrayList<>();

    public AuthorDto(Long id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public void addBook(BookDto book){
        books.add(book);
    }
}