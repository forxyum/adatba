package hu.bois.demo.model.identifier;

import java.io.Serializable;
import java.util.Objects;

public class AuthorId implements Serializable {
    private Long bookId;
    private String author;

    public AuthorId(Long bookId, String author) {
        this.bookId = bookId;
        this.author = author;
    }

    public AuthorId() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AuthorId)) return false;
        AuthorId authorId = (AuthorId) o;
        return bookId.equals(authorId.bookId) &&
                author.equals(authorId.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookId, author);
    }
}
