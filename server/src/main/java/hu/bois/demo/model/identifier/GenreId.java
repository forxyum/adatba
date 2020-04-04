package hu.bois.demo.model.identifier;

import java.io.Serializable;
import java.util.Objects;

public class GenreId implements Serializable {
    private Long bookId;
    private String genre;

    public GenreId(Long bookId, String genre) {
        this.bookId = bookId;
        this.genre = genre;
    }

    public GenreId() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GenreId)) return false;
        GenreId genreId = (GenreId) o;
        return bookId.equals(genreId.bookId) &&
                genre.equals(genreId.genre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookId, genre);
    }
}
