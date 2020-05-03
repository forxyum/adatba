package hu.bois.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import hu.bois.demo.model.Package;

@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;
    @Column(name = "title")
    private @NonNull String title;
    @Column(name = "publisher")
    private @NonNull String publisher;
    @Column(name = "year")
    private Date year;

    @Lob
    @Column(name="pic")
    private byte[] pic;


    public Book(String title, String publisher) {
        this.title = title;
        this.publisher = publisher;
    }
    public Book(Long id){
        this.id = id;
    }

    public Book(String title, String publisher, Date year) {
        this.title = title;
        this.publisher = publisher;
        this.year = year;
    }

    public Book(@NonNull String title, @NonNull String publisher, Date year, byte[] pic) {
        this.title = title;
        this.publisher = publisher;
        this.year = year;
        this.pic = pic;
    }

    public Book() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book book = (Book) o;
        return id.equals(book.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Date getYear() {
        return year;
    }

    public void setYear(Date year) {
        this.year = year;
    }

    public byte[] getPic() {
        return pic;
    }

    public void setPic(byte[] pic) {
        this.pic = pic;
    }
}