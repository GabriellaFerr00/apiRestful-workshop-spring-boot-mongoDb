package com.example.apiRestfulworkshopmongoDb.controllers;

import com.example.apiRestfulworkshopmongoDb.domain.entities.Post;
import com.example.apiRestfulworkshopmongoDb.dto.UserDTO;
import com.example.apiRestfulworkshopmongoDb.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/posts")
public class PostController {
    @Autowired
    private PostService postService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Post> FindById(@PathVariable String id){
        Post post = postService.findById(id);

        return ResponseEntity.ok().body(post);
    }
}
