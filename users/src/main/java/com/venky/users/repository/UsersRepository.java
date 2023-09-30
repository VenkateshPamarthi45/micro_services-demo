package com.venky.users.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.venky.users.entity.User;

public interface UsersRepository extends MongoRepository<User,String>{
    
}
