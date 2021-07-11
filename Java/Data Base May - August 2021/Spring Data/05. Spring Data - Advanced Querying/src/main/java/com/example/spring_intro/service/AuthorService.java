package com.example.spring_intro.service;

import com.example.spring_intro.model.entity.Author;

import java.io.IOException;
import java.util.List;

public interface AuthorService {
    void seedAuthors() throws IOException;

    Author getRandomAuthor();

    List<String> getAllAuthorsOrderByCountOfTheirBooksDesc();

    List<String> findAuthorsFirstNameEndsWithString(String endString);

    List<String> findAllAuthorsAndTheirTotalCopies();
}

