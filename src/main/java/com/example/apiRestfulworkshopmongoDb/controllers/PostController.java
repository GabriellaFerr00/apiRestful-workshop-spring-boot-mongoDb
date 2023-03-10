package com.example.apiRestfulworkshopmongoDb.controllers;

import com.example.apiRestfulworkshopmongoDb.controllers.util.URL;
import com.example.apiRestfulworkshopmongoDb.domain.entities.Post;
import com.example.apiRestfulworkshopmongoDb.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URLDecoder;
import java.util.Date;
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

    @GetMapping(value = "/titlesearch")
    public ResponseEntity<List<Post>> FindByTitle(@RequestParam(value = "text", defaultValue = "") String text){
        text = URL.decodeParam(text);
        List<Post> list = postService.findByTitle(text);

        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/fullsearch")
    public ResponseEntity<List<Post>> FindByFull(@RequestParam(value = "text", defaultValue = "") String text,
                                                 @RequestParam(value = "minDate", defaultValue = "") String minDate,
                                                 @RequestParam(value = "maxDate", defaultValue = "") String maxDate) {
        text = URL.decodeParam(text);
        Date min = URL.converteDate(minDate, new Date(0L));
        Date max = URL.converteDate(maxDate, new Date());
        List<Post> list = postService.findByFull(text, min, max);

        return ResponseEntity.ok().body(list);
    }
}
