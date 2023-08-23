package com.quangminh.transactionalreadonly.service;

import com.quangminh.transactionalreadonly.dto.AuthorDto;
import com.quangminh.transactionalreadonly.entity.Author;
import com.quangminh.transactionalreadonly.repository.AuthorRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.hibernate.engine.spi.EntityEntry;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.engine.spi.Status;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;

@Service
public class BookstoreService {
    @PersistenceContext
    private final EntityManager entityManager;

    private final AuthorRepository authorRepository;

    public BookstoreService(EntityManager entityManager, AuthorRepository authorRepository) {
        this.entityManager = entityManager;
        this.authorRepository = authorRepository;
    }

    @Transactional
    public void fetchAuthorReadWriteMode() {
        Author author = authorRepository.findFirstByGenre("Anthology");

        displayInformation("After Fetch", author);

        author.setAge(40);

        displayInformation("After Update Entity", author);

        // force flush - triggering manual flush is a code smell and should be avoided
        // in this case, by default, flush will take place before transaction commit
        authorRepository.flush();

        displayInformation("After Flush", author);
    }

    @Transactional(readOnly = true)
    public void fetchAuthorReadOnlyMode() {
        Author author = authorRepository.findFirstByGenre("Anthology");

        displayInformation("After Fetch", author);

        author.setAge(40);

        displayInformation("After Update Entity", author);

        // force flush - triggering manual flush is a code smell and should be avoided
        // be default, because we set readOnly=true, flush mode is MANUAL,
        // therefore no flush will take place
        authorRepository.flush();

        displayInformation("After Flush", author);
    }

    @Transactional
    public void fetchAuthorDtoReadWriteMode() {
        AuthorDto authorDto = authorRepository.findTopByGenre("Anthology");

        System.out.println("Author DTO: " + authorDto.getName() + ", " + authorDto.getAge());

        org.hibernate.engine.spi.PersistenceContext persistenceContext = getPersistenceContext();
        System.out.println("No of managed entities : " + persistenceContext.getNumberOfManagedEntities());
    }

    @Transactional(readOnly = true)
    public void fetchAuthorDtoReadOnlyMode() {
        AuthorDto authorDto = authorRepository.findTopByGenre("Anthology");

        System.out.println("Author DTO: " + authorDto.getName() + ", " + authorDto.getAge());

        org.hibernate.engine.spi.PersistenceContext persistenceContext = getPersistenceContext();
        System.out.println("No of managed entities : " + persistenceContext.getNumberOfManagedEntities());
    }

    private org.hibernate.engine.spi.PersistenceContext getPersistenceContext() {
        SharedSessionContractImplementor sharedSession = entityManager.unwrap(
                SharedSessionContractImplementor.class
        );

        return sharedSession.getPersistenceContext();
    }

    private void displayInformation(String phase, Author author) {

        System.out.println("\n-------------------------------------");
        System.out.println("Phase:" + phase);
        System.out.println("Entity: " + author);
        System.out.println("-------------------------------------");

        org.hibernate.engine.spi.PersistenceContext persistenceContext = getPersistenceContext();
        System.out.println("Has only non read entities : " + persistenceContext.hasLoadContext());

        EntityEntry entityEntry = persistenceContext.getEntry(author);
        Object[] loadedState = entityEntry.getLoadedState();
        Status status = entityEntry.getStatus();

        System.out.println("Entity entry : " + entityEntry);
        System.out.println("Status:" + status);
        System.out.println("Loaded state: " + Arrays.toString(loadedState));
    }

}
