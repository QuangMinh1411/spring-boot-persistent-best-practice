package com.example.cascadechildremoval.service;

import com.example.cascadechildremoval.entity.Author;
import com.example.cascadechildremoval.repository.AuthorRepository;
import com.example.cascadechildremoval.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookstoreService {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    @Transactional
    //One author is loaded in the persistent context
    public void deleteViaIdentifier(String name){
        Author author = authorRepository.findByName(name);
        bookRepository.deleteByAuthorIdentifier(author.getId());
        authorRepository.deleteByIdentifier(author.getId());
    }

    @Transactional
    //One Author and associated books in persistent context
    public void deleteViaIdentifierX(String name){
        Author author = authorRepository.findByNameWithBooks(name);
        bookRepository.deleteByAuthorIdentifier(author.getId());
        authorRepository.deleteByIdentifier(author.getId());
    }

    //More authors are loaded in the persistent context
    @Transactional
    public void  deleteViaBulkIn(int age){
        List<Author> authors = authorRepository.findByAge(age);
        bookRepository.deleteBulkByAuthors(authors);
        authorRepository.deleteInBatch(authors);
    }

    //No author and the associated book are in persistent context
    @Transactional
    public void deleteViaBulkInX(String genre){
        List<Author> authors = authorRepository.findByGenreWithBooks(genre);
        bookRepository.deleteBulkByAuthors(authors);
        authorRepository.deleteInBatch(authors);
    }
    //No Author or Book that should be deleted are loaded in the persistent context
    @Transactional
    public void deleteViaHardCodedIdentifier(Long id){
        bookRepository.deleteByAuthorIdentifier(id);
        authorRepository.deleteByIdentifier(id);
    }

    @Transactional
    //No author or book should be deleted are loaded persistent context
    public void deleteViaBulkHardCodeIdentifier(List<Long> ids){
        bookRepository.deleteBulkByAuthorIdentifier(ids);
        authorRepository.deleteBulkByIdentifier(ids);
    }

    public List<Author> getAllAuthor(){
        return authorRepository.findAll();
    }

}
