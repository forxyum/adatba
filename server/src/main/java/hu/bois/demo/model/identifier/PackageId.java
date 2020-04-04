package hu.bois.demo.model.identifier;

import java.io.Serializable;
import java.util.Objects;

public class PackageId implements Serializable {
    private Long supplyId;
    private Long bookId;

    public PackageId(Long supplyId, Long bookId) {
        this.supplyId = supplyId;
        this.bookId = bookId;
    }

    public PackageId() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PackageId)) return false;
        PackageId packageId = (PackageId) o;
        return supplyId.equals(packageId.supplyId) &&
                bookId.equals(packageId.bookId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(supplyId, bookId);
    }
}
