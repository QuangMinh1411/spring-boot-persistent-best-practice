package com.quangminh.joinstrategy.service;

import com.quangminh.joinstrategy.entity.Book;
import com.quangminh.joinstrategy.repository.BookRepository;
import com.quangminh.joinstrategy.strategy.Delivery;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DeliverService implements Deliverable{
    private final BookRepository bookRepository;
    private final List<Delivery> deliverStrategies;

    private final Map<Class<? extends Book>, Delivery> deliverStrategiesMap = new HashMap<>();

    public DeliverService(BookRepository bookRepository, List<Delivery> deliverStrategies) {
        this.bookRepository = bookRepository;
        this.deliverStrategies = deliverStrategies;
    }
    @PostConstruct
    public void init() {
        deliverStrategies.forEach((deliverStrategy) -> {
            deliverStrategiesMap.put(deliverStrategy.ofBook(), deliverStrategy);
        });
    }

    @Override
    public void process() {

        List<Book> allBooks = bookRepository.findAll();

        for (Book book : allBooks) {
            Delivery deliveryStrategy = deliverStrategiesMap.get(book.getClass());
            deliveryStrategy.deliver(book);
        }
    }
}
