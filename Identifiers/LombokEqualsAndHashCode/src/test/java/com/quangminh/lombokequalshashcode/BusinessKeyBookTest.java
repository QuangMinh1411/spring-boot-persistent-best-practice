package com.quangminh.lombokequalshashcode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
@Rollback(value = false)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class BusinessKeyBookTest {
    @Autowired
    private TestEntityManager entityManager;

    private static final BusinessKeyBook book = new BusinessKeyBook();
    private static final Set<BusinessKeyBook> books = new HashSet<>();

    @BeforeEach
    void setUp() {
        book.setTitle("Modern History");
        book.setIsbn("001-100-000-111");
        books.add(book);
//        entityManager.persistAndFlush(book);
    }
    @Test
    // Find in Set the book after it was persisted
    // State transition at first assertion point: NEW
    // State transition at second and third assertion point: MANAGED
    public void B_givenBookWhenPersistThenSuccess() throws Exception {

        assertNull(book.getId());

        entityManager.persistAndFlush(book);
        assertNotNull(book.getId());

        assertTrue(books.contains(book));
    }

    @Test
    // Find in Set the book after merge() was called - SELECT and UPDATE statement
    // State transition at assertion point: MANAGED
    public void C_givenBookWhenMergeThenSuccess() throws Exception {

        book.setTitle("New Modern History");
        BusinessKeyBook mergedBook = entityManager.merge(book);
        entityManager.flush();

        assertTrue(books.contains(mergedBook));
    }

    @Test
    // Find in Set the book after find() was called - SELECT statement
    // State transition at assertion point: MANAGED
    public void D_givenBookWhenFindThenSuccess() throws Exception {

        BusinessKeyBook foundBook = entityManager.find(BusinessKeyBook.class, book.getId());
        entityManager.flush();

        assertTrue(books.contains(foundBook));
    }

    @Test
    // Find in Set the book after detach() was called
    // State transition at assertion point: DETACHED
    public void E_givenBookWhenFindAndDetachThenSuccess() throws Exception {

        BusinessKeyBook foundBook = entityManager.find(BusinessKeyBook.class, book.getId());
        entityManager.detach(foundBook);

        assertTrue(books.contains(foundBook));
    }

    @Test
    // Find in Set the book after remove() was called - DELETE statement
    // State transition at assertion points: REMOVED
    public void F_givenBookWhenFindAndRemoveThenSuccess() throws Exception {

        BusinessKeyBook foundBook = entityManager.find(BusinessKeyBook.class, book.getId());
        entityManager.remove(foundBook);
        entityManager.flush();

        assertTrue(books.contains(foundBook));

        books.remove(foundBook);

        assertFalse(books.contains(foundBook));
    }
}