package hu.bois.demo.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

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

    @OneToMany(fetch = FetchType.LAZY)
    private List<Package> packages;

    public Book(String title, String publisher) {
        this.title = title;
        this.publisher = publisher;
    }

    public Book(String title, String publisher, Date year) {
        this.title = title;
        this.publisher = publisher;
        this.year = year;
    }

    public Book() {

    }

    public Book(Long id, Date year, List<Package> packages) {
        this.id = id;
        this.year = year;
        this.packages = packages;
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

    public List<Package> getPackages() {
        return packages;
    }

    public void setPackages(List<Package> packages) {
        this.packages = packages;
    }
}