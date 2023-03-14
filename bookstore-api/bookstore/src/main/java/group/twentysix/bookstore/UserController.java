package group.twentysix.bookstore;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return new ResponseEntity<List<User>>(userService.allUsers(), HttpStatus.OK);
    }

    @GetMapping("/{username}")
    public ResponseEntity<Optional<User>> getSingleUser(@PathVariable String username) {
        return new ResponseEntity<Optional<User>>(userService.singleUser(username), HttpStatus.OK);
    }

}
