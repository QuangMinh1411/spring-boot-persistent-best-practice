package com.heaven.subentities.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="author")
@Data
public class AuthorDeep extends BaseAuthor{
    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] avatar;
}
