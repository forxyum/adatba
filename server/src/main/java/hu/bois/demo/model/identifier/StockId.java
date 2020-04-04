package hu.bois.demo.model.identifier;

import java.io.Serializable;
import java.util.Objects;

public class StockId implements Serializable {
    private String storeAddress;
    private Long bookId;

    public StockId(String storeAddress, Long bookId) {
        this.storeAddress = storeAddress;
        this.bookId = bookId;
    }

    public StockId() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StockId)) return false;
        StockId stockId = (StockId) o;
        return storeAddress.equals(stockId.storeAddress) &&
                bookId.equals(stockId.bookId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(storeAddress, bookId);
    }
}
