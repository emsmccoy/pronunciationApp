package dev.pronunciationAppBack.controller;

import dev.pronunciationAppBack.service.UserService;
import dev.pronunciationAppBack.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    public UserService userService;

    private HttpHeaders getHeaders(String message) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Description", message);
        return headers;
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();

        return !users.isEmpty()
            ? ResponseEntity.ok().headers(getHeaders("Returning all users")).body(users)
            : ResponseEntity.notFound().headers(getHeaders("No users found")).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable String id) {
        Optional<User> user = userService.getUserById(id);

        return user.map(u -> ResponseEntity.ok().headers(getHeaders("User found")).body(u))
                .orElseGet(() -> ResponseEntity.notFound().headers(getHeaders("User not found")).build());
    }

    @PostMapping("/createUser")
    public ResponseEntity<User> createUser(@RequestBody User user){
        User createdUser = userService.createUser(user);

        URI location = URI.create("/users/" + createdUser.getId());
        //return ResponseEntity.ok().body(createdUser);
        //return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
        return ResponseEntity.created(location).headers(getHeaders("User created successfully")).body(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable String id, @RequestBody User user) {

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable String id, @RequestBody User user){

    }

    @DeleteMapping
    public ResponseEntity<String> deleteAllUsers(){

    }

    private HttpHeaders getCommonHeaders(String description) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", description);
        headers.add("content-type", "application/json");
        headers.add("date", new Date().toString());
        headers.add("server", "Spring Boot");
        headers.add("version", "1.0.0");
        headers.add("word-count", String.valueOf(userService.getUserCount()));
        headers.add("object", "words");
        return headers;
    }
}
