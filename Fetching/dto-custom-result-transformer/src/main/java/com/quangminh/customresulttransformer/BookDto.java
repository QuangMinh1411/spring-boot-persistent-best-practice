package com.quangminh.customresulttransformer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.quangminh.customresulttransformer.entity.Book}
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookDto implements Serializable {
    private Long id;
    private String title;
}