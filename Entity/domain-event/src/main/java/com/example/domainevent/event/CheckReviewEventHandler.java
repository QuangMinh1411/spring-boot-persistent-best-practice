package com.example.domainevent.event;

import com.example.domainevent.entity.BookReview;
import com.example.domainevent.entity.ReviewStatus;
import com.example.domainevent.repository.BookReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.event.TransactionalEventListener;

import java.util.Random;
import java.util.logging.Logger;

@Service
@RequiredArgsConstructor
public class CheckReviewEventHandler {
    private static final Logger logger = Logger.getLogger(CheckReviewEventHandler.class.getName());
    private final BookReviewRepository bookReviewRepository;

    @Async
    @TransactionalEventListener
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void handleCheckReviewEvent(CheckReviewEvent event){
        BookReview bookReview = event.getBookReview();
        logger.info(()->"Starting checking of review: " + bookReview.getId());

        try{
            String content = bookReview.getContent();
            String email = bookReview.getEmail();
            Thread.sleep(40000);
        }catch (InterruptedException ex){
            Thread.currentThread().interrupt();
        }

        if(new Random().nextBoolean()){
            bookReview.setStatus(ReviewStatus.ACCEPT);
            logger.info(()->"Book review "+bookReview.getId()+ " was accepted");
        }else {
            bookReview.setStatus(ReviewStatus.REJECT);
            logger.info(()->"Book review "+bookReview.getId()+ " was rejected");
        }
        bookReviewRepository.save(bookReview);
        logger.info(()->"Checking review "+ bookReview.getId()+ " done");
    }
}
