package com.quangminh.databasetrigger.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "book")
public class Book implements Serializable {
    private static final long serialVersionUID =1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "book_title")
    private String title;

    @Column(name = "book_isbn")
    private String isbn;

    @Column(name = "book_pages")
    private int pages;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Chapter> chapters = new ArrayList<>();
    public void addChapter(Chapter chapter) {
        this.chapters.add(chapter);
        chapter.setBook(this);
    }

    public void removeChapter(Chapter chapter) {
        chapter.setBook(null);
        this.chapters.remove(chapter);
    }

    public void removeChapters() {
        Iterator<Chapter> iterator = this.chapters.iterator();

        while (iterator.hasNext()) {
            Chapter chapter = iterator.next();

            chapter.setBook(null);
            iterator.remove();
        }
    }
}