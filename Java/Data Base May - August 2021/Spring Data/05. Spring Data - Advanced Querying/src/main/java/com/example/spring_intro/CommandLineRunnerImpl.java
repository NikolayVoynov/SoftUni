package com.example.spring_intro;

import com.example.spring_intro.model.entity.AgeRestriction;
import com.example.spring_intro.model.entity.Book;
import com.example.spring_intro.service.AuthorService;
import com.example.spring_intro.service.BookService;
import com.example.spring_intro.service.CategoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    private final CategoryService categoryService;
    private final AuthorService authorService;
    private final BookService bookService;
    private final BufferedReader bufferedReader;

    public CommandLineRunnerImpl(CategoryService categoryService, AuthorService authorService,
                                 BookService bookService, BufferedReader bufferedReader) {
        this.categoryService = categoryService;
        this.authorService = authorService;
        this.bookService = bookService;
        this.bufferedReader = bufferedReader;
    }

    @Override
    public void run(String... args) throws Exception {
        seedData();

//        printAllBooksAfterYear(2000);
//        printAllAuthorsNamesWithBooksWithReleaseDateBeforeYear(1990);
//        printAllAuthorsAndNumberOfTheirBooks();
//        printAllBooksByAuthorNameOrderByReleaseDate("George", "Powell");

        System.out.println("Please, select number of exercise or 0 to end program:");
        int exerciseNumber;
        while (0 != (exerciseNumber = Integer.parseInt(bufferedReader.readLine()))) {
            switch (exerciseNumber) {
                case 1 -> booksTitlesByAgeRestriction();
                case 2 -> goldenBook();
                case 3 -> booksByPrice();
                case 4 -> notReleasedBook();
                case 5 -> booksReleasedBeforeDate();
                case 6 -> authorsSearch();
                case 7 -> booksSearch();
                case 8 -> bookTitleSearch();
                case 9 -> countBooks();
                case 10 -> totalBookCopies();
                case 11 -> reducedBook();
            }

            System.out.println("Please, select number of exercise or 0 to end program:");
        }

        System.out.println("End of program!");
    }

    private void reducedBook() throws IOException {
        System.out.println("Enter book title:");
        String bookTitle = bufferedReader.readLine();

        System.out.println(bookService
                .retrieveInformationForBookWithTitle(bookTitle));
    }

    private void totalBookCopies() {
       authorService
                .findAllAuthorsAndTheirTotalCopies()
       .forEach(System.out::println);
    }

    private void countBooks() throws IOException {
        System.out.println("Enter title is longer than this number:");
        int givenNumber = Integer.parseInt(bufferedReader.readLine());

        System.out.println(bookService.findNumberOfAllBookTitlesLengthLongerThan(givenNumber));
    }

    private void bookTitleSearch() throws IOException {
        System.out.println("Enter Author last name starts with string:");
        String startString = bufferedReader.readLine();

        bookService
                .findAllTitleWithAuthorLastNameStartsWith(startString)
                .forEach(System.out::println);
    }

    private void booksSearch() throws IOException {
        System.out.println("Enter containing string:");
        String containedString = bufferedReader.readLine();

        bookService
                .findAllBookTitlesWhichContainString(containedString)
                .forEach(System.out::println);
    }

    private void authorsSearch() throws IOException {
        System.out.println("Enter first name ends with following string:");
        String endString = bufferedReader.readLine();

        authorService
                .findAuthorsFirstNameEndsWithString(endString)
                .forEach(System.out::println);
    }

    private void booksReleasedBeforeDate() throws IOException {
        System.out.println("Enter date in format dd-MM-yyyy:");
        LocalDate localDate = LocalDate.parse(bufferedReader.readLine(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));

        bookService
                .findAllBooksReleasedBeforeDate(localDate)
                .forEach(System.out::println);

    }

    private void notReleasedBook() throws IOException {
        System.out.println("Enter year:");
        int year = Integer.parseInt(bufferedReader.readLine());

        bookService
                .findBookTitlesNotReleasedInYear(year)
                .forEach(System.out::println);
    }

    private void booksByPrice() {
        bookService
                .findAllBooksTitlesAndPricesWithPriceLessThan5OrMoreThan40()
                .forEach(System.out::println);
    }

    private void goldenBook() {
        bookService
                .findAllGoldBookTitlesWithCopiesLessThan5000()
                .forEach(System.out::println);
    }

    private void booksTitlesByAgeRestriction() throws IOException {
        System.out.println("Enter Age Restriction:");
        AgeRestriction ageRestriction = AgeRestriction.valueOf(bufferedReader.readLine().toUpperCase());

        bookService.findAllBookTittlesWithAgeRestriction(ageRestriction)
                .forEach(System.out::println);
    }

    private void printAllBooksByAuthorNameOrderByReleaseDate(String firstName, String lastName) {
        bookService.
                findAllBooksByAuthorFirstAndLastNameOrderByReleaseDate(firstName, lastName)
                .forEach(System.out::println);
    }

    private void printAllAuthorsAndNumberOfTheirBooks() {
        authorService.getAllAuthorsOrderByCountOfTheirBooksDesc()
                .forEach(System.out::println);
    }

    private void printAllAuthorsNamesWithBooksWithReleaseDateBeforeYear(int year) {
        bookService
                .findAllAuthorsWithBooksWithReleaseDateBeforeYear(year)
                .forEach(System.out::println);
    }

    private void printAllBooksAfterYear(int year) {
        bookService
                .findAllBooksAfterYear(year)
                .stream()
                .map(Book::getTitle)
                .forEach(System.out::println);
    }

    private void seedData() throws IOException {
        categoryService.seedCategories();
        authorService.seedAuthors();
        bookService.seedBooks();
    }

}
