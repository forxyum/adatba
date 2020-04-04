package hu.bois.demo.model.identifier;

import hu.bois.demo.model.Book;
import hu.bois.demo.model.Supply;

import java.io.Serializable;
import java.util.Objects;

public class PackageId implements Serializable {
    private Supply supply;
    private Book book;

    public PackageId(Supply supply, Book book) {
        this.supply = supply;
        this.book = book;
    }

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
}
