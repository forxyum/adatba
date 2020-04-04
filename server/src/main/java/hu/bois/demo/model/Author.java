package hu.bois.demo.model;

import hu.bois.demo.model.identifier.AuthorId;
import lombok.NonNull;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name="author")
@IdClass(AuthorId.class)
public class Author {
    @Id private @NonNull Long bookId;
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
