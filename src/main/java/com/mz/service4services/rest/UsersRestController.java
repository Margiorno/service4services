package com.mz.service4services.rest;

import com.mz.service4services.entity.User;
import com.mz.service4services.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UsersRestController {

    private IUserService userService;

    @Autowired
    public UsersRestController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public List<User> getUsers() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable int id) {

        User user = userService.findById(id);

        if (user == null) {
            throw new RuntimeException("User not found");
        }

        return user;
    }

    @PostMapping("")
    public User addUser(@RequestBody User user) {

        user.setId(0);  // Ustawiamy ID na 0, by JPA potraktowało to jako nowy rekord

        User dbUser = userService.save(user);

        return dbUser;
    }

    @PutMapping("")
    public User updateUser(@RequestBody User user) {

        User dbUser = userService.save(user);

        return dbUser;
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable int id) {

        User user = userService.findById(id);

        if (user == null) {
            throw new RuntimeException("User not found");
        }

        userService.deleteById(id);
    }


}
