package bg.softuni.books.service;

import bg.softuni.books.model.dto.AuthorDTO;
import bg.softuni.books.model.dto.BookDTO;
import bg.softuni.books.model.entity.AuthorEntity;
import bg.softuni.books.model.entity.BookEntity;
import bg.softuni.books.repository.AuthorRepository;
import bg.softuni.books.repository.BookRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final ModelMapper modelMapper;

    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository, ModelMapper modelMapper) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<BookDTO> getAllBooks() {
        return bookRepository.
                findAll().
                stream().
                map(this::asBook)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<BookDTO> getBookById(Long id) {
        return bookRepository.findById(id).map(book -> modelMapper.map(book, BookDTO.class));
    }

    @Override
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public Long updateBook(BookDTO bookDTO) {
        BookEntity bookEntity = bookRepository.findById(bookDTO.getId()).orElse(null);

        if (bookEntity == null) {
            return null;
        }

        AuthorEntity authorEntity = authorRepository.
                findByName(bookDTO.getAuthor().getName()).
                orElseGet(() -> {
                    AuthorEntity newAuthor = new AuthorEntity().setName(bookDTO.getAuthor().getName());

                    return authorRepository.save(newAuthor);
                });

        bookEntity
                .setTitle(bookDTO.getTitle())
                .setIsbn(bookDTO.getIsbn())
                .setAuthor(authorEntity);

        return bookRepository.save(bookEntity).getId();
    }

    @Override
    public Long createBook(BookDTO bookDTO) {
        AuthorEntity authorEntity = authorRepository.
                findByName(bookDTO.getAuthor().getName()).
                orElseGet(() -> new AuthorEntity().setName(bookDTO.getAuthor().getName()));

        this.authorRepository.save(authorEntity);

        BookEntity newBook = new BookEntity();

        newBook.setTitle(bookDTO.getTitle()).setAuthor(authorEntity).setIsbn(bookDTO.getIsbn());

        return bookRepository.save(newBook).getId();
    }

    private BookDTO asBook(BookEntity book) {
        BookDTO bookDTO = modelMapper.map(book, BookDTO.class);
        AuthorDTO authorDTO = modelMapper.map(book.getAuthor(), AuthorDTO.class);

        bookDTO.setAuthor(authorDTO);

        return bookDTO;
    }

    @Override
    public Page<BookDTO> getBooks(int pageNo, int pageSize, String sortBy) {

        Pageable pageable = PageRequest.of(pageNo,pageSize, Sort.by(sortBy));

        return bookRepository.findAll(pageable).map(this::asBook);
    }
}
