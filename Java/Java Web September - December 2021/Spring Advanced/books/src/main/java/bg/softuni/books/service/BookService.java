package bg.softuni.books.service;

import bg.softuni.books.model.dto.BookDTO;

import java.util.List;

public interface BookService {
    List<BookDTO> getAllBooks();
}
