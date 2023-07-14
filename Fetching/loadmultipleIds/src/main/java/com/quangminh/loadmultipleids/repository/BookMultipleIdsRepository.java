package com.quangminh.loadmultipleids.repository;

import com.quangminh.loadmultipleids.entity.Book;
import com.quangminh.loadmultipleids.multipleids.MultipleIdsRepositoryImpl;
import org.springframework.stereotype.Repository;

@Repository
public class BookMultipleIdsRepository extends MultipleIdsRepositoryImpl<Book,Long> {

    public BookMultipleIdsRepository() {
        super(Book.class);
    }
}
