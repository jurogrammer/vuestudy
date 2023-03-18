package juro.vuestudy.user;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api")
@RestController
public class UserController {

    private final UserService userService;

    @GetMapping("/users")
    public List<User> readList(UserSearchCriteria userSearchCriteria) {

        return userService.userList(userSearchCriteria);
    }

    @PostMapping("/users/{id}")
    public User readUser(@PathVariable Long id) {
        return userService.getUser(id);
    }

    @PostMapping("/users")
    public void create(User user) {
        userService.createUser(user);
    }

    @PutMapping("/users/{id}")
    public void edit(User user) {
        userService.updateUser(user);
    }

    @DeleteMapping("/users/{id}")
    public void delete(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}
