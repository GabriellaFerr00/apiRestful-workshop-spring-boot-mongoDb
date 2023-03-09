package com.example.apiRestfulworkshopmongoDb.controllers;

import com.example.apiRestfulworkshopmongoDb.domain.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        List<User> userList = new ArrayList<>();

        User user1 = new User("1", "Alice Marcela", "alice@gmail.com");
        User user2 = new User("2", "Joao Guilherme", "joao@gmail.com");
        userList.addAll(Arrays.asList(user1, user2));

        return ResponseEntity.ok().body(userList);
    }
}
