package hu.bois.demo.model;

import lombok.*;

import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "book")
public class Book {
    @Id @GeneratedValue
    private Long id;
    private @NonNull String title;
    private @NonNull String publisher;
    private Date year;

    public Book(String title, String publisher) {
        this.title = title;
        this.publisher = publisher;
    }
    public Book(String title, String publisher,Date year) {
        this.title = title;
        this.publisher = publisher;
        this.year = year;
    }
    public Book(){

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
}