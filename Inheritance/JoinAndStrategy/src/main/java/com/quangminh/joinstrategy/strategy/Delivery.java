package com.quangminh.joinstrategy.strategy;

import com.quangminh.joinstrategy.entity.Book;

public interface Delivery <T extends Book> {
    Class<? extends Book> ofBook();

    void deliver(T book);
}
