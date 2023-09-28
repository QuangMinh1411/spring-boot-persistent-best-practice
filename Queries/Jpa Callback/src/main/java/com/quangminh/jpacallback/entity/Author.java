package com.quangminh.jpacallback.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.logging.Logger;

@Getter
@Setter
@Entity
@Table(name = "author")
public class Author implements Serializable {
    private static final Logger logger = Logger.getLogger(Author.class.getName());
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private int age;
    private String name;
    private String genre;

    @PrePersist
    private void prePersist() {
        logger.info("@PrePersist callback ...");
    }

    @PreUpdate
    private void preUpdate() {
        logger.info("@PreUpdate callback ...");
    }

    @PreRemove
    private void preRemove() {
        logger.info("@PreRemove callback ...");
    }

    @PostLoad
    private void postLoad() {
        logger.info("@PostLoad callback ...");
    }

    @PostPersist
    private void postPersist() {
        logger.info("@PostPersist callback ...");
    }

    @PostUpdate
    private void postUpdate() {
        logger.info("@PostUpdate callback ...");
    }

    @PostRemove
    private void postRemove() {
        logger.info("@PostRemove callback ...");
    }
}