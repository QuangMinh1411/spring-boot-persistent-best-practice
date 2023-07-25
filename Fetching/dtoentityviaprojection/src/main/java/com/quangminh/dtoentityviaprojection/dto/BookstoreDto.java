package com.quangminh.dtoentityviaprojection.dto;

import com.quangminh.dtoentityviaprojection.entity.Author;

/**
 * Projection for {@link com.quangminh.dtoentityviaprojection.entity.Book}
 */
public interface BookstoreDto {

    Author getAuthor();

    String getTitle();
}