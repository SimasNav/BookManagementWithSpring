package lt.simas.bookmanagementwithspring.model;

import lombok.Data;

@Data
public class BookDTO {

    private String title;
    private int pages;
    private double price;
}
