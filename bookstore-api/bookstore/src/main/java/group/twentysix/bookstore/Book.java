package group.twentysix.bookstore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "books")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @Id
    private ObjectId id;
    private String title;
    private List<String> genres;
    private double price;
    private String author;
    private String publisher;
    private int yearPublished;
    private List<String> comments;
    private String description;
    private int amountSold;
    private double rating;
    private int isbn;
}
