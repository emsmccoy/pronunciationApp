package dev.pronunciationAppBack.controller;

import dev.pronunciationAppBack.service.UserService;
import dev.pronunciationAppBack.model.UserApp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserAppController {

    @Autowired
    public UserService userService;

    private HttpHeaders getHeaders(String message) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Description", message);
        return headers;
    }

    @GetMapping
    public ResponseEntity<List<UserApp>> getAllUsers() {
        List<UserApp> users = userService.getAllUsers();

        return !users.isEmpty()
            ? ResponseEntity.ok().headers(getHeaders("Returning all users")).body(users)
            : ResponseEntity.notFound().headers(getHeaders("No users found")).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserApp> getUserById(@PathVariable String id) {
        Optional<UserApp> user = userService.getUserById(id);

        return user.map(u -> ResponseEntity.ok().headers(getHeaders("User found")).body(u))
                .orElseGet(() -> ResponseEntity.notFound().headers(getHeaders("User not found")).build());
    }

    @PostMapping("/createUser")
    public ResponseEntity<UserApp> createUser(@RequestBody UserApp user){
        UserApp createdUser = userService.createUser(user);

        //return ResponseEntity.ok().body(createdUser);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);

        //URI location = URI.create("/users/" + createdUser.getId());
        //return ResponseEntity.created(location).headers(getHeaders("User created successfully")).body(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserApp> updateUser(@PathVariable String id, @RequestBody UserApp user) {
        if (user.getId() != null && !user.getId().equals(id)) {
            return ResponseEntity.badRequest().headers(getHeaders("Mismatch between ID and user ID in body request")).build();
        } else {
            UserApp updatedUser = userService.updateUser(user);
            return ResponseEntity.ok().headers(getHeaders("User updated")).body(updatedUser);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable String id){
        if (userService.existsById(id)) {
            userService.deleteUser(id);
            return ResponseEntity.ok().headers(getHeaders("User deleted successfully")).build();
        } else {
            return ResponseEntity.notFound().headers(getHeaders("User not found")).build();
        }
    }

    @DeleteMapping
    public ResponseEntity<String> deleteAllUsers(){
        userService.deleteAllUsers();
        if (userService.getAllUsers().isEmpty()){
            return ResponseEntity.ok().headers(getHeaders("All users deleted succesfully")).build();
        } else {
            return ResponseEntity.notFound().headers(getHeaders("Could not delete all users")).build();
        }
    }

//    private HttpHeaders getCommonHeaders(String description) {
//        HttpHeaders headers = new HttpHeaders();
//        headers.add("desc", description);
//        headers.add("content-type", "application/json");
//        headers.add("date", new Date().toString());
//        headers.add("server", "Spring Boot");
//        headers.add("version", "1.0.0");
//        headers.add("word-count", String.valueOf(userService.getUserCount()));
//        headers.add("object", "words");
//        return headers;
//    }
}