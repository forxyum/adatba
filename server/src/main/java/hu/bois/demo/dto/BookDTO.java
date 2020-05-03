package hu.bois.demo.dto;

import hu.bois.demo.model.Book;
import org.modelmapper.ModelMapper;

import java.util.Date;

public class BookDTO {
    private Long id;
    private String title;
    private String publisher;
    private Date year;

    public static Book toEntity(BookDTO dto){
        ModelMapper mapper = new ModelMapper();
        return mapper.map(dto,Book.class);
    }
    public static BookDTO toDTO(Book entity){
        BookDTO dto = new BookDTO();
        dto.setId(entity.getId());
        dto.setTitle(entity.getTitle());
        dto.setPublisher(entity.getPublisher());
        dto.setYear(entity.getYear());
        return dto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Date getYear() {
        return year;
    }

    public void setYear(Date year) {
        this.year = year;
    }
}
