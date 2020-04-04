package hu.bois.demo.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name="supplier")
public class Supplier {
    @Id
    private @NonNull String username;
    private @NonNull String password;
    private @NonNull String email;
    private @NonNull Date birthDate;
    private @NonNull int balance;

    public Supplier(@NonNull String username, @NonNull String password, @NonNull String email, @NonNull Date birthDate, @NonNull int balance) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.birthDate = birthDate;
        this.balance = balance;
    }

    public Supplier() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
