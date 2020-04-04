package hu.bois.demo.model.identifier;

import java.io.Serializable;
import java.util.Objects;

public class PriceId implements Serializable {
    private Long bookId;
    private String storeAddress;

    public PriceId(Long bookId, String storeAddress) {
        this.bookId = bookId;
        this.storeAddress = storeAddress;
    }

    public PriceId() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PriceId)) return false;
        PriceId priceId = (PriceId) o;
        return bookId.equals(priceId.bookId) &&
                storeAddress.equals(priceId.storeAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookId, storeAddress);
    }
}
