package hu.bois.demo.model;

import hu.bois.demo.model.identifier.PackageId;
import lombok.NonNull;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "package")
@IdClass(PackageId.class)
public class Package {
    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id")
    private Book book;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "supply_id")
    private Supply supply;

    @Column(name = "amount")
    private @NonNull int amount;

    public Package() {
    }

    public Package(Book book, Supply supp, @NonNull int amount) {
        this.book = book;
        this.supply = supp;
        this.amount = amount;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Supply getSupply() {
        return supply;
    }

    public void setSupply(Supply supp) {
        this.supply = supp;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }


}
