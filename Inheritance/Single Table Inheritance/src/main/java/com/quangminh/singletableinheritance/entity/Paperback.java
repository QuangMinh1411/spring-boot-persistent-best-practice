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
@DiscriminatorValue("3")
public class Paperback extends Book implements Serializable {
    private static final long serialVersionUID = 1L;
    @NotNull
    private String sizeIn;
    @NotNull
    private String weightLbs;
}