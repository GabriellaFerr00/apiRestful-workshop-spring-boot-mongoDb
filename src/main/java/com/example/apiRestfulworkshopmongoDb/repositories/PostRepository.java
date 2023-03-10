package com.example.apiRestfulworkshopmongoDb.repositories;

import com.example.apiRestfulworkshopmongoDb.domain.entities.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
}
