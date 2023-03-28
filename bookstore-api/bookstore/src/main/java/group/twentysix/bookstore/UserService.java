package group.twentysix.bookstore;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.PathVariable;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> allUsers() {
        return userRepository.findAll();

    }

    public Optional<User> singleUser(String username) {

        return userRepository.findUserByUsername(username);
    }

    public User addUser(User newUser) {

        newUser.setUsername("Hurston");
        return newUser;
    }

    public User updateUser(String username, User userRequest) {
        User existingUser = userRepository.findUserByUsername(username).get();
        existingUser.setPassword(userRequest.getPassword());
        existingUser.setName(userRequest.getName());
        existingUser.setEmail(userRequest.getEmail());
        existingUser.setAddress(userRequest.getAddress());
        return userRepository.save(existingUser);
    }

    public User updateUserByFields(@PathVariable String username, Map<String, Object> fields) {
        Optional<User> existingUser = userRepository.findUserByUsername(username);

        if (existingUser.isPresent()) {
            fields.forEach((key, value) -> {
                Field field = ReflectionUtils.findField(User.class, key);
                field.setAccessible(true);
                ReflectionUtils.setField(field, existingUser.get(), value);
            });
            return userRepository.save(existingUser.get());
        }
        return null;
    }


}
