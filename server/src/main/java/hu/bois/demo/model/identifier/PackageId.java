package hu.bois.demo.model.identifier;

import java.io.Serializable;
import java.util.Objects;

public class PackageId implements Serializable {
    private Long supply;
    private Long book;



    public PackageId() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PackageId)) return false;
        PackageId packageId = (PackageId) o;
        return supply.equals(packageId.supply) &&
                book.equals(packageId.book);
    }

    @Override
    public int hashCode() {
        return Objects.hash(supply, book);
    }

    public Long getSupply() {
        return supply;
    }

    public void setSupply(Long supply) {
        this.supply = supply;
    }

    public Long getBook() {
        return book;
    }

    public void setBook(Long book) {
        this.book = book;
    }
}
