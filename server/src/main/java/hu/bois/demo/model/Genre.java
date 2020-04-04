package hu.bois.demo.model;

import hu.bois.demo.model.identifier.GenreId;
import lombok.NonNull;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name="genre")
@IdClass(GenreId.class)
public class Genre {
    @Id private @NonNull Long bookId;
    @Id private @NonNull String genre;

    public Genre(@NonNull Long bookId, @NonNull String genre) {
        this.bookId = bookId;
        this.genre = genre;
    }

    public Genre() {
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long book_id) {
        this.bookId = book_id;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
