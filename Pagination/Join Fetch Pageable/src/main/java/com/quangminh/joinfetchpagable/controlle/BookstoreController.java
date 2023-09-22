package com.quangminh.joinfetchpagable.controlle;

import com.quangminh.joinfetchpagable.service.BookstoreService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookstoreController {

    private final BookstoreService bookstoreService;

    public BookstoreController(BookstoreService bookstoreService) {
        this.bookstoreService = bookstoreService;
    }

    @GetMapping("/authors/{genre}/{page}/{size}")
    public ResponseEntity<?> fetchWithBooksByGenreCQ(@PathVariable String genre,
                                                     @PathVariable int page,
                                                     @PathVariable int size){
        return new ResponseEntity<>(bookstoreService.fetchWithBooksByGenreCQ(genre, page, size), HttpStatus.OK);
    }

    @GetMapping("/authors/eg/{genre}/{page}/{size}")
    public ResponseEntity<?> fetchWithBooksByGenreEG(@PathVariable String genre,
                                                     @PathVariable int page,
                                                     @PathVariable int size){
        return new ResponseEntity<>(bookstoreService.fetchWithBooksByGenreEG(genre, page, size), HttpStatus.OK);
    }

    @GetMapping("/books/{isbn}/{page}/{size}")
    public ResponseEntity<?> fetchWithAuthorsByIsbnCQ(@PathVariable String isbn,
                                                    @PathVariable int page,
                                                    @PathVariable int size){
        return new ResponseEntity<>(bookstoreService.fetchWithAuthorsByIsbnCQ(isbn, page, size), HttpStatus.OK);
    }

    @GetMapping("/books/eg/{isbn}/{page}/{size}")
    public ResponseEntity<?> fetchWithAuthorsByIsbnEG(@PathVariable String isbn,
                                                      @PathVariable int page,
                                                      @PathVariable int size){
        return new ResponseEntity<>(bookstoreService.fetchWithAuthorsByIsbnEG(isbn, page, size), HttpStatus.OK);
    }

}
