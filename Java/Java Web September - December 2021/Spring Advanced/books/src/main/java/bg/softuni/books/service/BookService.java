package bg.softuni.books.service;

import bg.softuni.books.model.dto.BookDTO;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<BookDTO> getAllBooks();

    Optional<BookDTO> getBookById(Long id);

    void deleteBook(Long id);

    Long updateBook(BookDTO bookDTO);

    Long createBook(BookDTO bookDTO);
}
