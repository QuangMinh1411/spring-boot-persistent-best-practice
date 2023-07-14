package com.quangminh.loadmultipleids.controller;

import com.quangminh.loadmultipleids.service.BookstoreService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookstoreController {
    private final BookstoreService service;

    public BookstoreController(BookstoreService service) {
        this.service = service;
    }

    @PostMapping("/muliplein")
    public ResponseEntity<?> fetchByMultipleIdsIn(@RequestBody List<Long> ids){
        return new ResponseEntity<>(service.fetchByMultipleIdsIn(ids), HttpStatus.OK);
    }
    @PostMapping("/muliple")
    public ResponseEntity<?> fetchByMultipleIds(@RequestBody List<Long> ids){
        return new ResponseEntity<>(service.fetchByMultipleIds(ids), HttpStatus.OK);
    }
    @PostMapping("/batchin")
    public ResponseEntity<?> fetchInBatchesByMultipleIds(@RequestBody List<Long> ids){
        return new ResponseEntity<>(service.fetchInBatchesByMultipleIds(ids), HttpStatus.OK);
    }
    @PostMapping("/sessionmultipleid")
    public ResponseEntity<?> fetchBySessionCheckMultipleIds(@RequestBody List<Long> ids){
        return new ResponseEntity<>(service.fetchBySessionCheckMultipleIds(ids), HttpStatus.OK);
    }
    @PostMapping("/sessionbatch")
    public ResponseEntity<?> fetchInBatchesBySessionCheckMultipleIds(@RequestBody List<Long> ids){
        return new ResponseEntity<>(service.fetchInBatchesBySessionCheckMultipleIds(ids), HttpStatus.OK);
    }

}
