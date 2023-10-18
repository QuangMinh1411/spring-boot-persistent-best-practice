package com.quangminh.sequentialnumber.controller;

import com.quangminh.sequentialnumber.service.BookstoreService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authors")
public class BookstoreController {

    private final BookstoreService bookstoreService;

    public BookstoreController(BookstoreService bookstoreService) {
        this.bookstoreService = bookstoreService;
    }

    @GetMapping("/sequence1")
    public ResponseEntity<?> fetchAuthorsWithSeqNumber1(){
        return new ResponseEntity<>(bookstoreService.fetchAuthorsWithSeqNumber1(), HttpStatus.OK);
    }

    @GetMapping("/sequence2")
    public ResponseEntity<?> fetchAuthorsWithSeqNumber2(){
        return new ResponseEntity<>(bookstoreService.fetchAuthorsWithSeqNumber2(), HttpStatus.OK);
    }

    @GetMapping("/sequence3")
    public ResponseEntity<?> fetchAuthorsWithSeqNumber3(){
        return new ResponseEntity<>(bookstoreService.fetchAuthorsWithSeqNumber3(), HttpStatus.OK);
    }

    @GetMapping("/sequence4")
    public ResponseEntity<?> fetchAuthorsWithSeqNumber4(){
        return new ResponseEntity<>(bookstoreService.fetchAuthorsWithSeqNumber4(), HttpStatus.OK);
    }

    @GetMapping("/rank1")
    public ResponseEntity<?> fetchAuthorsWithRank1(){
        return new ResponseEntity<>(bookstoreService.fetchAuthorsWithRank1(),HttpStatus.OK);
    }

    @GetMapping("/rank2")
    public ResponseEntity<?> fetchAuthorsWithRank2(){
        return new ResponseEntity<>(bookstoreService.fetchAuthorsWithRank2(),HttpStatus.OK);
    }

    @GetMapping("/dense-rank1")
    public ResponseEntity<?> fetchAuthorsWithDenseRank1(){
        return new ResponseEntity<>(bookstoreService.fetchWithDenseRank1(),HttpStatus.OK);
    }

    @GetMapping("/dense-rank2")
    public ResponseEntity<?> fetchAuthorsWithDenseRank2(){
        return new ResponseEntity<>(bookstoreService.fetchWithDenseRank2(),HttpStatus.OK);
    }

    @GetMapping("/dense-rank3")
    public ResponseEntity<?> fetchAuthorsWithDenseRank3(){
        return new ResponseEntity<>(bookstoreService.fetchWithDenseRank3(),HttpStatus.OK);
    }

    @GetMapping("/ntile1")
    public ResponseEntity<?> fetchWithNTile1(){
        return new ResponseEntity<>(bookstoreService.fetchWithNTile1(),HttpStatus.OK);
    }
    @GetMapping("/ntile2")
    public ResponseEntity<?> fetchWithNTile2(){
        return new ResponseEntity<>(bookstoreService.fetchWithNTile2(),HttpStatus.OK);
    }

    @GetMapping("/ntile3")
    public ResponseEntity<?> fetchWithNTile3(){
        return new ResponseEntity<>(bookstoreService.fetchWithNTile3(),HttpStatus.OK);
    }
}
