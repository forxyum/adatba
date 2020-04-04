package hu.bois.demo.model;

import hu.bois.demo.model.identifier.PackageId;
import lombok.NonNull;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name="package")
@IdClass(PackageId.class)
public class Package {
    @Id private @NonNull Long supplyId;
    @Id private @NonNull Long bookId;
    private @NonNull int amount;

    public Package(@NonNull Long supplyId, @NonNull Long bookId, @NonNull int amount) {
        this.supplyId = supplyId;
        this.bookId = bookId;
        this.amount = amount;
    }

    public Package() {
    }

    public Long getSupplyId() {
        return supplyId;
    }

    public void setSupplyId(Long supply_id) {
        this.supplyId = supply_id;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long book_id2) {
        this.bookId = book_id2;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
