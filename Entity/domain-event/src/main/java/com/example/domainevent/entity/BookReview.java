package com.example.domainevent.entity;

import com.example.domainevent.event.CheckReviewEvent;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.AbstractAggregateRoot;
import java.io.Serializable;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class BookReview extends AbstractAggregateRoot implements Serializable {
    private static final long serialVersionUID =1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;
    private String email;
    @Enumerated(EnumType.STRING)
    private ReviewStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="book_id")
    private Book book;

    public void registerReviewEvent(){
        registerEvent(new CheckReviewEvent(this));
    }

}
