package hu.bois.demo.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import hu.bois.demo.model.identifier.PackageId;
import lombok.NonNull;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "package")
@IdClass(PackageId.class)
public class Package{
    @Id
    @Column(name = "book_id")
    private Long book;

    @Id
    @Column(name = "supply_id")
    private Long supply;

    @Column(name = "amount")
    private @NonNull Long amount;

    public Package() {
    }

    public Package(Long book, Long supp, @NonNull Long amount) {
        this.book = book;
        this.supply = supp;
        this.amount = amount;
    }

    public Long getBook() {
        return book;
    }

    public void setBook(Long book) {
        this.book = book;
    }

    public Long getSupply() {
        return supply;
    }

    public void setSupply(Long supply) {
        this.supply = supply;
    }

    public @NonNull Long getAmount() {
        return amount;
    }

    public void setAmount(@NonNull Long amount) {
        this.amount = amount;
    }


}
