package com.example.apiRestfulworkshopmongoDb.controllers;

import com.example.apiRestfulworkshopmongoDb.domain.entities.User;
import com.example.apiRestfulworkshopmongoDb.dto.UserDTO;
import com.example.apiRestfulworkshopmongoDb.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll(){
        List<User> userList = userService.findAll();

        List<UserDTO> userDTOS = userList.stream()
                .map(x -> new UserDTO(x))
                .collect(Collectors.toList());

        return ResponseEntity.ok().body(userDTOS);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable String id){
        User user = userService.findById(id);

        return ResponseEntity.ok().body(new UserDTO(user));

    }

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody UserDTO dto){
        User user = userService.fromDTO(dto);
        user = userService.insert(user);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(user.getId())
                .toUri(); // pega o endereco do novo objeto que inseri

        return ResponseEntity.created(uri).build();

    }

}
