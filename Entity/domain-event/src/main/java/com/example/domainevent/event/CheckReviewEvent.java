package com.example.domainevent.event;

import com.example.domainevent.entity.BookReview;

public class CheckReviewEvent {
    private final BookReview bookReview;


    public CheckReviewEvent(BookReview bookReview) {
        this.bookReview = bookReview;
    }

    public BookReview getBookReview(){
        return bookReview;
    }
}
