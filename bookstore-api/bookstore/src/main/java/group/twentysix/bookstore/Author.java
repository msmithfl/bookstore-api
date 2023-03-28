package group.twentysix.bookstore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;
@Document(collection = "Author")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Author {
    @Id
    private ObjectId id;
    private String firstName;
    private String lastName;
    private String biography;
    private String publisher;
}
