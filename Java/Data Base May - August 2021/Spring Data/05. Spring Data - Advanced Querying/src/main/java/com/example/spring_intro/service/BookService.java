package com.example.spring_intro.service;

import com.example.spring_intro.model.entity.AgeRestriction;
import com.example.spring_intro.model.entity.Book;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public interface BookService {
    void seedBooks() throws IOException;

    List<Book> findAllBooksAfterYear(int year);

    List<String> findAllAuthorsWithBooksWithReleaseDateBeforeYear(int year);

    List<String> findAllBooksByAuthorFirstAndLastNameOrderByReleaseDate(String firstName, String lastName);

    List<String> findAllBookTittlesWithAgeRestriction(AgeRestriction ageRestriction);

    List<String> findAllGoldBookTitlesWithCopiesLessThan5000();

    List<String> findAllBooksTitlesAndPricesWithPriceLessThan5OrMoreThan40();

    List<String> findBookTitlesNotReleasedInYear(int year);

    List<String> findAllBooksReleasedBeforeDate(LocalDate localDate);

    List<String> findAllBookTitlesWhichContainString(String containedString);

    List<String> findAllTitleWithAuthorLastNameStartsWith(String startString);

    int findNumberOfAllBookTitlesLengthLongerThan(int givenNumber);

    String retrieveInformationForBookWithTitle(String bookTitle);
}
