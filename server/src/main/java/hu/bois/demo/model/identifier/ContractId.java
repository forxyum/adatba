package hu.bois.demo.model.identifier;

import java.io.Serializable;
import java.util.Objects;

public class ContractId implements Serializable {
    private String supplierUsername;
    private int companyTax;

    public ContractId(String supplierUsername, int companyTax) {
        this.supplierUsername = supplierUsername;
        this.companyTax = companyTax;
    }

    public ContractId() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ContractId)) return false;
        ContractId that = (ContractId) o;
        return companyTax == that.companyTax &&
                supplierUsername.equals(that.supplierUsername);
    }

    @Override
    public int hashCode() {
        return Objects.hash(supplierUsername, companyTax);
    }
}
