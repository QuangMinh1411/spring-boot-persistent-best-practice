package com.quangminh.singletableinheritance.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Entity
@DiscriminatorValue("2")
public class Ebook extends Book implements Serializable {
    private static final long serialVersionUID = 1L;
    @NotNull
    private String format;

}