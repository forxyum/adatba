package hu.bois.demo.model;

import hu.bois.demo.model.identifier.AuthorId;
import lombok.NonNull;

import javax.persistence.*;

@Entity
@Table(name="author")
@IdClass(AuthorId.class)
public class Author {
    @Column(name="book_id")
    @Id private @NonNull Long bookId;
    @Column(name="author")
    @Id private @NonNull String author;

    public Author(Long id,String author){
        this.bookId = id;
        this.author = author;
    }

    public Author() {
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long auth_id) {
        this.bookId = auth_id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
