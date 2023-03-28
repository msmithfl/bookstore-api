package group.twentysix.bookstore;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
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
@PostMapping("/user/add")
@ResponseStatus(HttpStatus.CREATED)
    public User addUser (@RequestBody User newUser) {
        return userService.addUser(newUser);

    }
@PutMapping("/{username}")
    public User updateUser (@PathVariable String username,@RequestBody User userRequest) {
        return userService.updateUser(username, userRequest);
    }

@PatchMapping("/{username}")
public User updateUserFields(@PathVariable String username, @RequestBody Map<String,Object> fields){
    return userService.updateUserByFields(username,fields);

}


}
