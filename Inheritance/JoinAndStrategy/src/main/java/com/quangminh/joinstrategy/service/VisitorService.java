package com.quangminh.joinstrategy.service;

import com.quangminh.joinstrategy.entity.Book;
import com.quangminh.joinstrategy.entity.Ebook;
import com.quangminh.joinstrategy.entity.Paperback;
import com.quangminh.joinstrategy.repository.BookRepository;
import com.quangminh.joinstrategy.visitor.Visitor;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class VisitorService implements Visitable{
    private final BookRepository bookRepository;
    private final List<Visitor> visitors;

    private final Map<Class<? extends Visitor>, Visitor> visitorsMap = new HashMap<>();

    public VisitorService(BookRepository bookRepository, List<Visitor> visitors) {
        this.bookRepository = bookRepository;
        this.visitors = visitors;
    }

    @PostConstruct
    public void init() {
        visitors.forEach((visitor) -> {
            visitorsMap.put(visitor.getClass(), visitor);
        });
    }

    @Override
    public void accept(Class<? extends Visitor> clazzVisitor) {

        List<Book> allBooks = bookRepository.findAll();

        if (!allBooks.isEmpty()) {

            Visitor currentVisitor = visitorsMap.get(clazzVisitor);

            for (Book book : allBooks) {
                ClazzName clazzName = ClazzName.valueOf(book.getClass().getSimpleName());

                switch (clazzName) {
                    case Ebook:
                        currentVisitor.visit((Ebook) book);
                        break;
                    case Paperback:
                        currentVisitor.visit((Paperback) book);
                        break;
                    default:
                        throw new IllegalArgumentException("Unkown book type!");
                }
            }
        }
    }

    enum ClazzName {
        Ebook, Paperback
    }
}
