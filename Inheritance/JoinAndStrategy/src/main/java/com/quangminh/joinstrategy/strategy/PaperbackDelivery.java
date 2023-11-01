package com.quangminh.joinstrategy.strategy;

import com.quangminh.joinstrategy.entity.Book;
import com.quangminh.joinstrategy.entity.Paperback;
import org.springframework.stereotype.Component;

@Component
public class PaperbackDelivery implements Delivery<Paperback> {
    @Override
    public void deliver(Paperback book) {
        System.out.println("We've sent you a parcel containing the title " + book.getTitle()
                + " with a size of '" + book.getSizeIn() +"' and a weight of " + book.getWeightLbs());
    }

    @Override
    public Class<? extends Book> ofBook() {
        return Paperback.class;
    }
}
