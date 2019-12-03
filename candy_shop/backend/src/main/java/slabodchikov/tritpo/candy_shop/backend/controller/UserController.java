package slabodchikov.tritpo.candy_shop.backend.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import slabodchikov.tritpo.candy_shop.backend.entity.User;
import slabodchikov.tritpo.candy_shop.backend.service.UserService;

@RequestMapping(value = "/api/users")
@RestController
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public Iterable<User> getAll() {
        return userService.findAll();
    }

    @GetMapping(value = "/{userId}")
    public User getById(@PathVariable(name = "userId") Long id) {
        return userService.findById(id).orElse(null);
    }

    @PostMapping
    public User saveUser(@RequestBody User user) {
        return userService.save(user);
    }

    @DeleteMapping(value = "/{userId}")
    public void deleteUser(@PathVariable(name = "userId") Long id) {
        userService.deleteById(id);
    }
}
