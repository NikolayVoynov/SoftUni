package bg.softuni.books.model.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "books")
public class BookEntity extends BaseEntity {

    private String title;
    private String isbn;
    private AuthorEntity author;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @ManyToOne
    public AuthorEntity getAuthor() {
        return author;
    }

    public void setAuthor(AuthorEntity author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "BookEntity{" +
                "title='" + title + '\'' +
                ", isbn='" + isbn + '\'' +
                ", author=" + author +
                '}';
    }
}
