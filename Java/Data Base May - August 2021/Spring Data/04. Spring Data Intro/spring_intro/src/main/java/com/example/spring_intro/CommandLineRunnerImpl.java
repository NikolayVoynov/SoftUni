package com.example.spring_intro;

import com.example.spring_intro.model.entity.Book;
import com.example.spring_intro.service.AuthorService;
import com.example.spring_intro.service.BookService;
import com.example.spring_intro.service.CategoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    private final CategoryService categoryService;
    private final AuthorService authorService;
    private final BookService bookService;
    private final BufferedReader bufferedReader;

    public CommandLineRunnerImpl(CategoryService categoryService, AuthorService authorService, BookService bookService) {
        this.categoryService = categoryService;
        this.authorService = authorService;
        this.bookService = bookService;
        this.bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void run(String... args) throws Exception {
        seedData();

        System.out.println("Enter number of exercise or 0 to end program:");
        int exerciseNumber;
        while (0 != (exerciseNumber = Integer.parseInt(bufferedReader.readLine()))) {
            switch (exerciseNumber) {
                case 1:
                    printAllBooksAfterYear(2000);
                    break;
                case 2:
                    printAllAuthorsNamesWithBooksWithReleaseDateBeforeYear(1990);
                    break;
                case 3:
                    printAllAuthorsAndNumberOfTheirBooks();
                    break;
                case 4:
                    printAllBooksByAuthorNameOrderByReleaseDate("George", "Powell");
                    break;
            }

            System.out.println("Enter number of exercise or 0 to end program:");
        }

        System.out.println("End of program!");
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
