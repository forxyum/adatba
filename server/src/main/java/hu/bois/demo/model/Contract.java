package hu.bois.demo.model;

import hu.bois.demo.model.identifier.ContractId;
import lombok.NonNull;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="contract")
@IdClass(ContractId.class)
public class Contract {
    @Column(name="supplier_username")
    @Id private @NonNull String supplierUsername;
    @Column(name="company_tax")
    @Id private @NonNull int companyTax;
    @Column(name="start_date")
    private @NonNull Date startDate;
    @Column(name="end_date")
    private @NonNull Date endDate;

    public Contract(@NonNull String supplierUsername, @NonNull int companyTax, @NonNull Date startDate, @NonNull Date endDate) {
        this.supplierUsername = supplierUsername;
        this.companyTax = companyTax;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Contract() {
    }

    public String getSupplierUsername() {
        return supplierUsername;
    }

    public void setSupplierUsername(String supplier_username) {
        this.supplierUsername = supplier_username;
    }

    public int getCompanyTax() {
        return companyTax;
    }

    public void setCompanyTax(int company_tax2) {
        this.companyTax = company_tax2;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date start_date) {
        this.startDate = start_date;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date end_date) {
        this.endDate = end_date;
    }
}
