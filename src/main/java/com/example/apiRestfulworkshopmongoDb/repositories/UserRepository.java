package com.example.apiRestfulworkshopmongoDb.repositories;

import com.example.apiRestfulworkshopmongoDb.domain.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
}
