package com.quangminh.transactionalreadonly.dto;

/**
 * Projection for {@link com.quangminh.transactionalreadonly.entity.Author}
 */
public interface AuthorDto {
    int getAge();

    String getName();
}