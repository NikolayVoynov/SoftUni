package com.example.spring_intro.repository;

import com.example.spring_intro.model.entity.AgeRestriction;
import com.example.spring_intro.model.entity.Book;
import com.example.spring_intro.model.entity.EditionType;
import org.hibernate.annotations.Parameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {

    List<Book> findAllByReleaseDateAfter(LocalDate releaseDateAfter);

    List<Book> findAllByReleaseDateBefore(LocalDate releaseDateBefore);

    List<Book> findAllByAuthor_FirstNameAndAuthor_LastNameOrderByReleaseDateDescTitle(String author_firstName, String author_lastName);

    List<Book> findAllByAgeRestriction(AgeRestriction ageRestriction);

    List<Book> findAllByEditionTypeAndCopiesLessThan(EditionType editionType, Integer copies);

    List<Book> findAllByPriceLessThanOrPriceGreaterThan(BigDecimal lower, BigDecimal upper);

    List<Book> findAllByReleaseDateBeforeOrReleaseDateAfter(LocalDate lower, LocalDate upper);

    List<Book> findByTitleContains(String containedString);

    List<Book> findAllByAuthor_LastNameStartsWith(String startString);

    @Query("SELECT count(b) FROM Book b WHERE length(b.title) > :requiredLength ")
    int countOfBooksWithTitleLengthMoreThan(@Param(value = "requiredLength") int givenNumber);

    Book findBookByTitle(String title);
}

