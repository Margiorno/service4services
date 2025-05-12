package com.mz.service4services.rest;

import com.mz.service4services.entity.User;
import com.mz.service4services.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UsersController {

    private IUserService userService;

    @Autowired
    public UsersController(IUserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signUp")
    public ResponseEntity<String> signUp(@RequestBody Map<String, String> body) {
        String email = body.get("email");
        String password = body.get("password");
        String firstname = body.get("first_name");
        String lastname = body.get("last_name");

        try {
            User user = userService.signUp(email,password,firstname,lastname);
            return ResponseEntity.ok("Registered user with email: " + user.getEmail());
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/signIn")
    public ResponseEntity<String> signIn(@RequestBody Map<String, String> body) {
        String email = body.get("email");
        String password = body.get("password");

        try {
            String user = userService.signIn(email,password);
            return ResponseEntity.ok(user);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
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
