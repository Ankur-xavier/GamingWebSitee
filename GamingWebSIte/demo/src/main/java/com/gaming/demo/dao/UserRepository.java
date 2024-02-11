package com.gaming.demo.dao;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.gaming.demo.entities.User;

public interface UserRepository extends MongoRepository<User, String> {
    
}
