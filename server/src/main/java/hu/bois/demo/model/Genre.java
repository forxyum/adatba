package hu.bois.demo.model;

import hu.bois.demo.model.identifier.GenreId;
import lombok.NonNull;

import javax.persistence.*;

@Entity
@Table(name="genre")
@IdClass(GenreId.class)
public class Genre {
    @Column(name="book_id")
    @Id private @NonNull Long bookId;
    @Column(name="genre")
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
