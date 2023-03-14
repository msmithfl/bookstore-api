package group.twentysix.bookstore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "payments")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {
    @Id
    private ObjectId id;

    private String cardNumber;

    private String cardDate;

    private String cv;

    private String zipcode;

    public Payment(String cardNumber) {
        this.cardNumber = cardNumber;
    }

}
