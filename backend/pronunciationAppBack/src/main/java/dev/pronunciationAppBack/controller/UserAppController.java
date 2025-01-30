package dev.pronunciationAppBack.controller;

import dev.pronunciationAppBack.service.UserAppService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserAppController {

    @Autowired
    public UserAppService userAppService;

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {

    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable String id) {

    }


}
