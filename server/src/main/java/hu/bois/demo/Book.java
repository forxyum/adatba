package hu.bois.demo;

import lombok.*;

import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Entity;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class Book {
    @Id @GeneratedValue
    private Long id;
    private @NonNull String title;
    private @NonNull String published;
    private Date year;

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}