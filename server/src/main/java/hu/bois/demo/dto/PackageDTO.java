package hu.bois.demo.dto;

import hu.bois.demo.model.Book;
import hu.bois.demo.model.Package;
import hu.bois.demo.model.Supply;
import org.modelmapper.ModelMapper;

import javax.validation.constraints.NotNull;

public class PackageDTO {
    @NotNull
    private Long supplyId;
    @NotNull
    private Long bookId;
    @NotNull
    private Long amount;

    public static Package toEntity(PackageDTO dto,Book book, Supply supp){
        return null;
    }
    public static PackageDTO toDTO(Package entity){
        PackageDTO dto = new PackageDTO();
        return dto;
    }

    public PackageDTO() {
    }


    public Long getSupplyId() {
        return supplyId;
    }

    public void setSupplyId(Long supplyId) {
        this.supplyId = supplyId;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }
}
