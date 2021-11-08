package bg.softuni.books.service;

import bg.softuni.books.model.dto.BookDTO;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<BookDTO> getAllBooks();

    Optional<BookDTO> getBookById(Long id);

    Page<BookDTO> getBooks(int pageNo, int pageSize, String sortBy);

    void deleteBook(Long id);

    Long updateBook(BookDTO bookDTO);

    Long createBook(BookDTO bookDTO);
}
