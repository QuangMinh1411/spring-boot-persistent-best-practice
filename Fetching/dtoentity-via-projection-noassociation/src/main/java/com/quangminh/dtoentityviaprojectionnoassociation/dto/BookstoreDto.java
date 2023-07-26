package com.quangminh.dtoentityviaprojectionnoassociation.dto;

import com.quangminh.dtoentityviaprojectionnoassociation.entity.Author;

/**
 * Projection for {@link com.quangminh.dtoentityviaprojectionnoassociation.entity.Book}
 */
public interface BookstoreDto {
    Author getAuthor();
    String getTitle();
}