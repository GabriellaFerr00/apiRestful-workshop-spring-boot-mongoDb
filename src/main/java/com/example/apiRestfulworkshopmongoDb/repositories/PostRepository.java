package com.example.apiRestfulworkshopmongoDb.repositories;

import com.example.apiRestfulworkshopmongoDb.domain.entities.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
    List<Post> findByTitleContainingIgnoreCase(String text);

    @Query("{ 'title': { $regex: ?0, $options: 'i' } }")
    List<Post> findByTitle(String text);

    @Query("{ $and: [ {date: {$gte: ?1} }, {date: {$lte: ?} }, " +
            "{ $or: [ { 'title': { $regex: ?0, $options: 'i' } }, { 'body': { $regex: ?0, $options: 'i' } }," +
            " { 'comments.text': { $regex: ?0, $options: 'i' } } ] } ] }")
    List<Post> findByFull(String text, Date minDate, Date maxDate);

}
