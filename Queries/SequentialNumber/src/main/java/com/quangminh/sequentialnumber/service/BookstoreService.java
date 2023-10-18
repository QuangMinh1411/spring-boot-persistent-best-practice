package com.quangminh.sequentialnumber.service;

import com.quangminh.sequentialnumber.dto.AuthorDtoDenseRank;
import com.quangminh.sequentialnumber.dto.AuthorDtoRank;
import com.quangminh.sequentialnumber.dto.AuthorDto;
import com.quangminh.sequentialnumber.dto.AuthorNTileDto;
import com.quangminh.sequentialnumber.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookstoreService {

    private final AuthorRepository authorRepository;

    public BookstoreService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }
    public List<AuthorDto> fetchAuthorsWithSeqNumber1() {
        List<AuthorDto> authors = authorRepository.fetchWithSeqNumber1();

        authors.forEach(a -> System.out.println(a.getRowNum()
                + ", " + a.getName() + ", " + a.getAge()));
        return authors;
    }

    public List<AuthorDto> fetchAuthorsWithSeqNumber2() {
        List<AuthorDto> authors = authorRepository.fetchWithSeqNumber2();

        authors.forEach(a -> System.out.println(a.getRowNum()
                + ", " + a.getName() + ", " + a.getAge()));
        return authors;
    }

    public List<AuthorDto> fetchAuthorsWithSeqNumber3() {
        List<AuthorDto> authors = authorRepository.fetchWithSeqNumber3();

        authors.forEach(a -> System.out.println(a.getRowNum()
                + ", " + a.getName() + ", " + a.getAge()));
        return authors;
    }

    public List<AuthorDto> fetchAuthorsWithSeqNumber4() {
        List<AuthorDto> authors = authorRepository.fetchWithSeqNumber4();

        authors.forEach(a -> System.out.println(a.getRowNum()
                + ", " + a.getName() + ", " + a.getAge()));
        return authors;
    }

    //Rank
    public List<AuthorDtoRank> fetchAuthorsWithRank1() {
        List<AuthorDtoRank> authors = authorRepository.fetchWithRank1();

        authors.forEach(a -> System.out.println(a.getRankNum()
                + ", " + a.getName() + ", " + a.getGenre()));
        return authors;
    }

    public List<AuthorDtoRank> fetchAuthorsWithRank2() {
        List<AuthorDtoRank> authors = authorRepository.fetchWithRank2();

        authors.forEach(a -> System.out.println(a.getRankNum()
                + ", " + a.getName() + ", " + a.getGenre()));
        return authors;
    }

    public List<AuthorDtoDenseRank> fetchWithDenseRank1() {
        return authorRepository.fetchWithDenseRank1();
    }

    public List<AuthorDtoDenseRank> fetchWithDenseRank2() {
        return authorRepository.fetchWithDenseRank2();
    }

    public List<AuthorDtoDenseRank> fetchWithDenseRank3() {
        return authorRepository.fetchWithDenseRank3();
    }

    public List<AuthorNTileDto> fetchWithNTile1(){
        return authorRepository.fetchWithNTile1();
    }

    public List<AuthorNTileDto> fetchWithNTile2(){
        return authorRepository.fetchWithNTile2();
    }

    public List<AuthorNTileDto> fetchWithNTile3(){
        return authorRepository.fetchWithNTile3();
    }
}
