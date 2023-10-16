package com.quangminh.dbviewmodify.service;

import com.quangminh.dbviewmodify.repository.AuthorAnthologyViewRepository;
import com.quangminh.dbviewmodify.view.AuthorAnthologyView;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookstoreService {

    private final AuthorAnthologyViewRepository authorAnthologyViewRepository;

    public BookstoreService(AuthorAnthologyViewRepository authorAnthologyViewRepository) {
        this.authorAnthologyViewRepository = authorAnthologyViewRepository;
    }

    @Transactional
    public void updateAuthorAgeViaView() {
        AuthorAnthologyView author
                = authorAnthologyViewRepository.findByName("Quartis Young");

        author.setAge(author.getAge() + 1);
    }

    public void insertAuthorViaView() {
        AuthorAnthologyView newAuthor = new AuthorAnthologyView();
        newAuthor.setName("Toij Kalu");
        newAuthor.setGenre("Anthology");
        newAuthor.setAge(42);

        authorAnthologyViewRepository.save(newAuthor);
    }

    @Transactional
    public void deleteAuthorViaView() {
        AuthorAnthologyView author
                = authorAnthologyViewRepository.findByName("Mark Janel");

        authorAnthologyViewRepository.delete(author);
    }

    // Doesn't work
    // WITH CHECK OPTION doesn't allow this insert
    // expect to see: java.sql.SQLException: CHECK OPTION failed 'bookstoredb.author_anthology_view'
    public void insertHistoryAuthorInView() {
        AuthorAnthologyView author = new AuthorAnthologyView();
        author.setName("Mark Powell");
        author.setGenre("History"); // this field doesn't pass the check
        author.setAge(45);

        authorAnthologyViewRepository.save(author);
    }
}
