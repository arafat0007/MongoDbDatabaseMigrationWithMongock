package com.example.MongockMongoDB.Repository;

import com.example.MongockMongoDB.Model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}
