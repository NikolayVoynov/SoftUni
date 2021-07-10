package com.example.spring_intro.service.impl;

import com.example.spring_intro.model.entity.Author;
import com.example.spring_intro.repository.AuthorRepository;
import com.example.spring_intro.service.AuthorService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Service
public class AuthorServiceImpl implements AuthorService {

    private static final String AUTHORS_FILE_PATH = "src/main/resources/files/authors.txt";

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public void seedAuthors() throws IOException {

        if (authorRepository.count() > 0) {
            return;
        }

        Files.readAllLines(Path.of(AUTHORS_FILE_PATH))
                .stream()
                .filter(row -> !row.isEmpty())
                .collect(Collectors.toList())
                .forEach(authorName -> {
                    String[] authorFullName = authorName.split("\\s+");
                    String authorFirstName = authorFullName[0];
                    String authorLastName = authorFullName[1];
                    Author author = new Author(authorFirstName, authorLastName);

                    authorRepository.save(author);
                });

    }

    @Override
    public Author getRandomAuthor() {
        long randomId = ThreadLocalRandom.current().nextLong(1, authorRepository.count() + 1);


        return authorRepository.findById(randomId).orElse(null);
    }

    @Override
    public List<String> getAllAuthorsOrderByCountOfTheirBooksDesc() {
        return authorRepository
                .findAllByBooksSizeDesc()
                .stream()
                .map(author -> String.format("%s %s %d",
                        author.getFirstName(),
                        author.getLastName(),
                        author.getBooks().size()))
                .collect(Collectors.toList());
    }
}
