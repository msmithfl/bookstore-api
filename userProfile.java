
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection = "userProfile")
public class userProfile {
    private String userName;
    private String password;
    private String name;
    private String email;
    private String address;
}
