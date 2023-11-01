package com.quangminh.joinstrategy.strategy;

import com.quangminh.joinstrategy.entity.Book;
import com.quangminh.joinstrategy.entity.Ebook;
import org.springframework.stereotype.Component;

@Component
public class EbookDelivery implements Delivery<Ebook> {
    @Override
    public void deliver(Ebook book) {
        System.out.println("You can download the book named '" + book.getTitle()
                + "' from the following link: http://bookstore/" + book.getFormat()
                + "/" + book.getTitle());
    }

    @Override
    public Class<? extends Book> ofBook() {
        return Ebook.class;
    }

}
