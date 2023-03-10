package com.example.apiRestfulworkshopmongoDb.services;

import com.example.apiRestfulworkshopmongoDb.domain.entities.Post;
import com.example.apiRestfulworkshopmongoDb.exception.ObjectNotFoundException;
import com.example.apiRestfulworkshopmongoDb.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    public Post findById(String id){
        Optional<Post> post = postRepository.findById(id);
        return post.orElseThrow(() -> new ObjectNotFoundException("Object not found"));
    }

    public List<Post> findByTitle(String text){
        return postRepository.findByTitle(text);
    }

    public List<Post> findByFull(String text, Date minDate, Date maxDate){
        maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
        return postRepository.findByFull(text, minDate, maxDate);
    }

}
